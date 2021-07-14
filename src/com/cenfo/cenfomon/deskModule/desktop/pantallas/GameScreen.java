package com.cenfo.cenfomon.deskModule.desktop.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.cenfo.cenfomon.deskModule.desktop.Controllers.ControllerJugador;
import com.cenfo.cenfomon.deskModule.desktop.Entidades.Actor;
import com.cenfo.cenfomon.deskModule.desktop.Entidades.Camara;
import com.cenfo.cenfomon.deskModule.desktop.Entidades.TERRENO;
import com.cenfo.cenfomon.deskModule.desktop.Entidades.TileMap;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;

import com.cenfo.cenfomon.deskModule.desktop.conf.Juego;
import com.cenfo.cenfomon.deskModule.desktop.conf.Settings;
import com.cenfo.cenfomon.deskModule.desktop.utilities.AnimationSet;


public class GameScreen extends  AbstractScreen{
    private Texture redStandingSouth;
    private Texture grass1;
    private Texture grass2;
    private SpriteBatch batch;
    private Actor player;
    private ControllerJugador playerController;
    private Camara camara;
    private TileMap map;

    public GameScreen(Juego j) {
        super(j);
        redStandingSouth = new Texture("res/un_packed/brendan_walk_south_1.png");
        grass1=new Texture("res/un_packed/grass1.png");
        grass2=new Texture("res/un_packed/grass2.png");
        batch=new SpriteBatch();

        TextureAtlas atlas= j.getAssetManager().get("res/packed/textures.atlas",TextureAtlas.class);

        AnimationSet animations = new AnimationSet(
                new Animation(0.3f/2f, atlas.findRegions("brendan_walk_north"), PlayMode.LOOP_PINGPONG),
                new Animation(0.3f/2f, atlas.findRegions("brendan_walk_south"), PlayMode.LOOP_PINGPONG),
                new Animation(0.3f/2f, atlas.findRegions("brendan_walk_east"), PlayMode.LOOP_PINGPONG),
                new Animation(0.3f/2f, atlas.findRegions("brendan_walk_west"), PlayMode.LOOP_PINGPONG),
                atlas.findRegion("brendan_stand_north"),
                atlas.findRegion("brendan_stand_south"),
                atlas.findRegion("brendan_stand_east"),
                atlas.findRegion("brendan_stand_west")
        );



        map=new TileMap(10,10);
        camara=new Camara();
        player=new Actor(map,0,0,animations);
        playerController=new ControllerJugador(player);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(playerController);

    }

    @Override
    public void render(float delta) {
        playerController.actualizarMovimiento(delta);
        player.Actualizar(delta);
        camara.Actualizar(player.getWorldX()+0.5f,player.getWorldY()+0.5f);




        batch.begin();

        float worldStartX=Gdx.graphics.getWidth()/5 - camara.getCamaraX()* Settings.SCALE_TILE_SIZE;
        float worldStartY=Gdx.graphics.getHeight()/5-camara.getCamaraY()*Settings.SCALE_TILE_SIZE;



        for(int x=0;x<map.getWidth();x++){
            for(int y=0;y<map.getHeight();y++){
                Texture render;
                if (map.getTile(x,y).getTerreno()== TERRENO.GRASS_1){
                    render=grass1;
                }else{
                    render=grass2;
                }
                batch.draw(render,
                        worldStartX+x*Settings.SCALE_TILE_SIZE,
                        worldStartY+y*Settings.SCALE_TILE_SIZE,
                        Settings.SCALE_TILE_SIZE,
                        Settings.SCALE_TILE_SIZE);
            }
        }
        batch.draw(player.getSprite(),
                worldStartX+player.getWorldX()* Settings.SCALE_TILE_SIZE,
                worldStartY+player.getWorldY()*Settings.SCALE_TILE_SIZE,
                Settings.SCALE_TILE_SIZE,
                Settings.SCALE_TILE_SIZE*1.5f);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}