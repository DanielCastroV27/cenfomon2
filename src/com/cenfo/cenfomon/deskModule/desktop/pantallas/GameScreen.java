package com.cenfo.cenfomon.deskModule.desktop.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;

import com.cenfo.cenfomon.deskModule.desktop.Controllers.ControllerJugador;
import com.cenfo.cenfomon.deskModule.desktop.Entidades.*;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;

import com.cenfo.cenfomon.deskModule.desktop.conf.Juego;
import com.cenfo.cenfomon.deskModule.desktop.conf.Settings;
import com.cenfo.cenfomon.deskModule.desktop.pantallas.renderer.WorldRenderer;
import com.cenfo.cenfomon.deskModule.desktop.utilities.AnimationSet;


public class GameScreen extends AbstractScreen {
    private Texture grass1;
    private Texture grass2;
    private SpriteBatch batch;
    private Actor player;
    private ControllerJugador playerController;
    private Camara camara;
    private World world;
    private WorldRenderer worldRenderer;
    private Juego game;

    public GameScreen(Juego j) {
        super(j);
        this.game = j;
        grass1 = new Texture("res/un_packed/grass1.png");
        grass2 = new Texture("res/un_packed/grass2.png");
        batch = new SpriteBatch();

        TextureAtlas atlas = j.getAssetManager().get("res/packed/textures.atlas", TextureAtlas.class);
        AnimationSet animations = new AnimationSet(
                new Animation(0.3f / 2f, atlas.findRegions("brendan_walk_north"), PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, atlas.findRegions("brendan_walk_south"), PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, atlas.findRegions("brendan_walk_east"), PlayMode.LOOP_PINGPONG),
                new Animation(0.3f / 2f, atlas.findRegions("brendan_walk_west"), PlayMode.LOOP_PINGPONG),
                atlas.findRegion("brendan_stand_north"),
                atlas.findRegion("brendan_stand_south"),
                atlas.findRegion("brendan_stand_east"),
                atlas.findRegion("brendan_stand_west")
        );

        this.camara = new Camara();
        this.world = new World(20, 20);
        this.player = new Actor(this.world.getMap(), 2, 2, animations);
        this.world.addActor(this.player);
        this.playerController = new ControllerJugador(player);
        this.worldRenderer = new WorldRenderer(j.getAssetManager(), world, batch);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(playerController);
    }

    @Override
    public void render(float delta) {
        this.playerController.actualizarMovimiento(delta);

        this.camara.Actualizar(player.getWorldX() + 0.5f, player.getWorldY() + 0.5f);
        this.world.update(delta);

        this.batch.begin();
        this.worldRenderer.render(camara);
        this.batch.end();
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