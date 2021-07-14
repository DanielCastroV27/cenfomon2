package com.cenfo.cenfomon.deskModule.desktop.pantallas;

import com.badlogic.gdx.Screen;
import com.cenfo.cenfomon.deskModule.desktop.conf.Juego;

public abstract class AbstractScreen implements Screen {
    public AbstractScreen(Juego j){

    }
    @Override
    public abstract void show();

    @Override
    public abstract void render(float delta);

    @Override
    public abstract void resize(int width, int height);

    @Override
    public abstract void pause();

    @Override
    public abstract void resume();

    @Override
    public abstract void hide();

    @Override
    public abstract void dispose();
}