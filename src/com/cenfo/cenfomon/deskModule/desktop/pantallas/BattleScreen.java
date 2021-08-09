package com.cenfo.cenfomon.deskModule.desktop.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.cenfo.cenfomon.deskModule.desktop.Controllers.BattleController;
import com.cenfo.cenfomon.deskModule.desktop.Controllers.DialogueController;
import com.cenfo.cenfomon.deskModule.desktop.Entidades.TileMap;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concreteproduct.Osotias;
import com.cenfo.cenfomon.deskModule.desktop.conf.Juego;
import com.cenfo.cenfomon.deskModule.desktop.dialogues.DialogueNode;
import com.cenfo.cenfomon.deskModule.desktop.pantallas.renderer.BattleScreenRenderer;
import com.cenfo.cenfomon.deskModule.desktop.ui.DetailedStatusBox;
import com.cenfo.cenfomon.deskModule.desktop.ui.StatusBox;

import java.util.List;

public class BattleScreen extends AbstractScreen {

    private SpriteBatch batch;
    private BattleScreenRenderer battleScreenRenderer;
    private Juego game;
    private AbstractCenfomon enemyCenfomon;
    private AbstractCenfomon playerCenfomon = new Osotias();
    private BattleType battleType;

    //UI
    private Stage uiStage;
    private int uiScale = 2;
    private Viewport gameViewport;

    private DetailedStatusBox opponentStatus;
    private DetailedStatusBox playerStatus;

    private Table statusBoxRoot;

    //Controllers
    private DialogueController dialogueController;
    private BattleController battleController;
    private InputMultiplexer inputMultiplexer;

    public BattleScreen(Juego j, AbstractCenfomon cenfomon, BattleType battleType) {
        super(j);
        game = j;
        batch = j.batch;
        enemyCenfomon = cenfomon;
        this.battleType = battleType;
        battleScreenRenderer = new BattleScreenRenderer(batch, cenfomon);
        dialogueController = new DialogueController(j.getSkin());
        battleController = new BattleController(j.getSkin());
        battleController.setPlayerCenfomon(playerCenfomon);
        battleController.setEnemyCenfomon(enemyCenfomon);

        uiStage = new Stage(new ScreenViewport());
        uiStage.getViewport().update(Gdx.graphics.getWidth() / uiScale, Gdx.graphics.getHeight() / uiScale, true);
        gameViewport = new ScreenViewport();

        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(0, dialogueController);
        inputMultiplexer.addProcessor(1, battleController);

        initUI();
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
        battle();
        opponentStatus.getHPBar().updateHpAmount(enemyCenfomon.getHealthAmount());
        opponentStatus.setHPText((int) enemyCenfomon.getHealthAmount(), 100);
        playerStatus.getHPBar().updateHpAmount(playerCenfomon.getHealthAmount());
        playerStatus.setHPText((int) playerCenfomon.getHealthAmount(), 100);
    }

    private void battle() {
        battleController.showAttacks();
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
        uiStage.addActor(battleController.getTableRoot());
        uiStage.addActor(statusBoxRoot);

        opponentStatus = new DetailedStatusBox(game.getSkin(), enemyCenfomon);
        playerStatus = new DetailedStatusBox(game.getSkin(), new Osotias());
        statusBoxRoot.add(playerStatus).expand().align(Align.left);
        statusBoxRoot.add(opponentStatus).expand().align(Align.right);
    }

    private void initDialogues() {
        if (battleType == BattleType.TRAINING) {
            trainingDialogues();
        } else {
            //TODO: Battle dialogs
        }
    }

    private void trainingDialogues() {
        DialogueNode node1 = new DialogueNode("Escoge un ataque", 0);
        DialogueNode node2 = new DialogueNode("Lista de ataques:", 1);
        DialogueNode node3 = new DialogueNode("PUMMMMM!", 2);

        dialogueController.makeLinear(node1, node2.getID());
        dialogueController.addChoice(node2, "Ataque 1", node3.getID());
        dialogueController.addChoice(node2, "Ataque 2", node3.getID());
        dialogueController.addChoice(node2, "Ataque 3", node3.getID());
        dialogueController.addEndNode(node3);

        dialogueController.startDialogue();
    }
}
