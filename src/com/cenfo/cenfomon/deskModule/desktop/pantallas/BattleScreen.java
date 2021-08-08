package com.cenfo.cenfomon.deskModule.desktop.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.conf.Juego;
import com.cenfo.cenfomon.deskModule.desktop.conf.Settings;
import com.cenfo.cenfomon.deskModule.desktop.pantallas.renderer.BattleScreenRenderer;
import com.cenfo.cenfomon.deskModule.desktop.ui.StatusBox;

import java.util.List;

public class BattleScreen extends AbstractScreen{

    private SpriteBatch batch;
    private BattleScreenRenderer battleScreenRenderer;
    private Juego game;
    private AbstractCenfomon enemyCenfomon;

    //UI
    private Stage uiStage;
    private StatusBox opponentStatus;

    private Table statusBoxRoot;

    public BattleScreen(Juego j, AbstractCenfomon cenfomon) {
        super(j);
        game = j;
        batch = j.batch;
        enemyCenfomon = cenfomon;
        battleScreenRenderer = new BattleScreenRenderer(batch, cenfomon);

        initUI();
    }

    public BattleScreen(Juego j, List<AbstractCenfomon> cenfomons) {
        super(j);
        batch = j.batch;
        battleScreenRenderer = new BattleScreenRenderer(batch, cenfomons);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        battleScreenRenderer.render();
        batch.end();

        uiStage.draw();
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

    private void initUI() {
        uiStage = new Stage(new ScreenViewport());
        statusBoxRoot = new Table();
        statusBoxRoot.setFillParent(true);

        uiStage.addActor(statusBoxRoot);
        opponentStatus = new StatusBox(game.getSkin(), enemyCenfomon);
        //opponentStatus.setText(enemyCenfomon.getName());
        statusBoxRoot.add(opponentStatus).expand().align(Align.right);
    }
}
