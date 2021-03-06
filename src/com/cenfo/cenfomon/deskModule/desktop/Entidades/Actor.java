package com.cenfo.cenfomon.deskModule.desktop.Entidades;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.badlogic.gdx.math.Interpolation;
import com.cenfo.cenfomon.deskModule.desktop.utilities.AnimationSet;


public class Actor {
    private TileMap map;
    private int x;
    private int y;
    private DIRECCION facingDirection;

    private float worldX,worldY;

    private int srcX,srcY;
    private int destinationX,destinationY;

    private float timerAnimacion;
    private float ANIM_TIME=0.3f;

    private float timerCaminar;
    private boolean moveRequestThisFrame;

    private ACTOR_STATE state;

    private AnimationSet animacionesActor;

    public float getWorldX() {
        return worldX;
    }

    public float getWorldY() {
        return worldY;
    }

    public enum ACTOR_STATE{
        WALKING,
        STANDING,
        ;
    }
    public void Actualizar(float delta){
        if(state==ACTOR_STATE.WALKING){
            timerAnimacion+=delta;
            timerCaminar+=delta;
            worldX= Interpolation.pow2.apply(srcX,destinationX,timerAnimacion/ANIM_TIME);
            worldY=Interpolation.pow2.apply(srcY,destinationY,timerAnimacion/ANIM_TIME);
            if(timerAnimacion>ANIM_TIME){
                float leftOverTime=timerAnimacion-ANIM_TIME;
                timerCaminar-=leftOverTime;
                FinalizarMovimiento();
                if(moveRequestThisFrame){
                    move(facingDirection);
                }else{
                    timerCaminar=0f;
                }
            }
        }
        moveRequestThisFrame=false;
    }

    public int getX() {
        return x;
    }
    public boolean move( DIRECCION dir){
        if(state==ACTOR_STATE.WALKING){
            if (facingDirection==dir){
                moveRequestThisFrame=true;
            }
            return false;
        }
        if(x+ dir.getDx()>=map.getWidth()||x+dir.getDx()<0||y+dir.getDy()>=map.getHeight()||y+dir.getDy()<0){
            return false;
        }
        if (map.getTile(x+dir.getDx(),y+ dir.getDy()).getActor()!=null){
            return false;
        }
        InicializarMovimiento(dir);
        map.getTile(x,y).setActor(null);
        x+=dir.getDx();
        y+=dir.getDy();
        map.getTile(x,y).setActor(this);
        return true;
    }
    private void InicializarMovimiento(DIRECCION dir){
        this.facingDirection=dir;
        this.srcX=x;
        this.srcY=y;
        this.destinationX=x+dir.getDx();
        this.destinationY=y+dir.getDy();
        this.worldX=x;
        this.worldY=y;
        timerAnimacion=0f;
        state=ACTOR_STATE.WALKING;

    }
    private void FinalizarMovimiento(){
        state=ACTOR_STATE.STANDING;
        this.worldY=destinationY;
        this.worldX=destinationX;
        this.srcY=0;
        this.srcX=0;
        this.destinationX=0;
        this.destinationY=0;

    }


    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Actor(TileMap map,int x, int y,AnimationSet animaciones) {
        this.map=map;
        this.x = x;
        this.y = y;
        this.worldX=x;
        this.worldY=y;
        this.animacionesActor=animaciones;
        map.getTile(x,y).setActor(this);
        this.state=ACTOR_STATE.STANDING;
        this.facingDirection=DIRECCION.SUR;
    }
    public TextureRegion getSprite(){
        if (state==ACTOR_STATE.WALKING){
            return  this.animacionesActor.getWalking(this.facingDirection).getKeyFrame(this.timerCaminar);
        }else if(state==ACTOR_STATE.STANDING){
            return  animacionesActor.getStanding(facingDirection);
        }
        return animacionesActor.getStanding(DIRECCION.SUR);
    }
}

