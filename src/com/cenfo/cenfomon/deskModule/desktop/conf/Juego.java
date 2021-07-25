package com.cenfo.cenfomon.deskModule.desktop.conf;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.cenfo.cenfomon.deskModule.desktop.pantallas.GameScreen;
import com.badlogic.gdx.graphics.GL20;
import com.cenfo.cenfomon.deskModule.desktop.pantallas.MainMenuScreen;
import com.cenfo.cenfomon.deskModule.desktop.pantallas.OfficeScreen;
import com.cenfo.cenfomon.deskModule.desktop.utilities.SkinGenerator;


public class Juego extends Game {
    private AssetManager assetManager;
    public SpriteBatch batch;
    private Skin skin;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    @Override
    public void create() {
        batch = new SpriteBatch();
        assetManager=new AssetManager();
        assetManager.load("res/packed/textures.atlas", TextureAtlas.class);
        assetManager.load("res/packed/uipack.atlas", TextureAtlas.class);
        assetManager.load("res/font/small_letters_font.fnt", BitmapFont.class);
        assetManager.finishLoading();
        this.skin = SkinGenerator.generateSkin(assetManager);
        this.setScreen(new MainMenuScreen(this));

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

    public Skin getSkin() {
        return skin;
    }
}
