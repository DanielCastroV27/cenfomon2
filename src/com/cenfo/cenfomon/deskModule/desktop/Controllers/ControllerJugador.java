package com.cenfo.cenfomon.deskModule.desktop.Controllers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.cenfo.cenfomon.deskModule.desktop.Entidades.Actor;
import com.cenfo.cenfomon.deskModule.desktop.Entidades.DIRECCION;


public class ControllerJugador extends InputAdapter {
    private Actor player;
    public ControllerJugador(Actor p){
        this.player=p;
    }
    private boolean arriba,abajo,derecha,izquierda;

    @Override
    public boolean keyDown(int keycode) {
        if(keycode== Input.Keys.UP){
            //player.move(0,1);
            arriba=true;
        } if(keycode== Input.Keys.DOWN){
            abajo=true;
            //player.move(0,-1);

        } if(keycode== Input.Keys.RIGHT){
            //player.move(1,0);
            derecha=true;
        } if(keycode== Input.Keys.LEFT){
            // player.move(-1,0 );
            izquierda=true;
        }

        return false;
        //return super.keyDown(keycode);
    }
    @Override
    public boolean keyUp(int keycode){
        if(keycode== Input.Keys.UP){
            //player.move(0,1);
            arriba=false;
        } if(keycode== Input.Keys.DOWN){
            abajo=false;
            //player.move(0,-1);

        } if(keycode== Input.Keys.RIGHT){
            //player.move(1,0);
            derecha=false;
        } if(keycode== Input.Keys.LEFT){
            // player.move(-1,0 );
            izquierda=false;
        }

        return false;
    }
    public void actualizarMovimiento(float delta){
        if(arriba){
            player.move(DIRECCION.NORTE);

        }
        if(abajo){
            player.move(DIRECCION.SUR);
        }
        if(derecha){
            player.move(DIRECCION.ESTE);
        }
        if(izquierda){
            player.move(DIRECCION.OESTE);
        }
    }
}