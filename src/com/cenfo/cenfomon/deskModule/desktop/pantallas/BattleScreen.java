package com.cenfo.cenfomon.deskModule.desktop.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.cenfo.cenfomon.deskModule.desktop.Controllers.DialogueController;
import com.cenfo.cenfomon.deskModule.desktop.Entidades.TileMap;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.conf.Juego;
import com.cenfo.cenfomon.deskModule.desktop.dialogues.DialogueNode;
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
    private int uiScale = 2;
    private Viewport gameViewport;

    private StatusBox opponentStatus;

    private Table statusBoxRoot;

    //Controllers
    private DialogueController dialogueController;
    private InputMultiplexer inputMultiplexer;

    public BattleScreen(Juego j, AbstractCenfomon cenfomon, BattleType battleType) {
        super(j);
        game = j;
        batch = j.batch;
        enemyCenfomon = cenfomon;
        battleScreenRenderer = new BattleScreenRenderer(batch, cenfomon);
        dialogueController = new DialogueController(j.getSkin());

        uiStage = new Stage(new ScreenViewport());
        uiStage.getViewport().update(Gdx.graphics.getWidth() / uiScale, Gdx.graphics.getHeight() / uiScale, true);
        gameViewport = new ScreenViewport();

        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(0, dialogueController);


        initUI();



        initDialogues();
    }

    public BattleScreen(Juego j, List<AbstractCenfomon> cenfomons) {
        super(j);
        batch = j.batch;
        battleScreenRenderer = new BattleScreenRenderer(batch, cenfomons);
    }

    @Override
    public TileMap getMap() {
        return null;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public void render(float delta) {
        gameViewport.apply();

        batch.begin();
        battleScreenRenderer.render();
        batch.end();
        uiStage.draw();
        dialogueController.update();
        uiStage.act(delta);
    }

    @Override
    public void resize(int width, int height) {
        batch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
        uiStage.getViewport().update(width / uiScale, height / uiScale, true);
        gameViewport.update(width, height);
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

        statusBoxRoot = new Table();
        statusBoxRoot.setFillParent(true);

        uiStage.addActor(dialogueController.getTableRoot());
        uiStage.addActor(statusBoxRoot);
        opponentStatus = new StatusBox(game.getSkin(), enemyCenfomon);
        statusBoxRoot.add(opponentStatus).expand().align(Align.right);
    }

    private void initDialogues() {
        DialogueNode node1 = new DialogueNode("hahaha 1", 0);
        DialogueNode node2 = new DialogueNode("hahaha 2", 1);
        dialogueController.makeLinear(node1, node2.getID());
        dialogueController.addEndNode(node2);
        dialogueController.startDialogue();
    }
}
