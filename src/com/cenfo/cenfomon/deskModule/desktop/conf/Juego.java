package com.cenfo.cenfomon.deskModule.desktop.conf;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import com.cenfo.cenfomon.deskModule.desktop.pantallas.GameScreen;
import com.badlogic.gdx.graphics.GL20;


public class Juego extends Game {
    private GameScreen screen;
    private AssetManager assetManager;

    @Override
    public void create() {
        assetManager=new AssetManager();
        assetManager.load("res/packed/textures.atlas", TextureAtlas.class);
        assetManager.finishLoading();
        screen=new GameScreen(this);
        this.setScreen(screen);

    }
    @Override
    public void render () {
        Gdx.gl.glClearColor(0f,0f,0f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        super.render();
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }
}
