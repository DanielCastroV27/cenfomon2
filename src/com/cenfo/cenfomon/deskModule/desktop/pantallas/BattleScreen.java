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
import com.cenfo.cenfomon.deskModule.desktop.conf.Juego;
import com.cenfo.cenfomon.deskModule.desktop.dialogues.DialogueNode;
import com.cenfo.cenfomon.deskModule.desktop.pantallas.renderer.BattleScreenRenderer;
import com.cenfo.cenfomon.deskModule.desktop.ui.DetailedStatusBox;
import com.cenfo.cenfomon.deskModule.desktop.utilities.singleton.Singleton;

import java.util.List;

public class BattleScreen extends AbstractScreen {

    private SpriteBatch batch;
    private BattleScreenRenderer battleScreenRenderer;
    private Juego game;
    private AbstractCenfomon enemyCenfomon;
    private AbstractCenfomon playerCenfomon;
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
    private boolean endBattle;

    public BattleScreen(Juego j, AbstractCenfomon cenfomon, BattleType battleType) {
        super(j);
        game = j;
        batch = j.batch;
        enemyCenfomon = cenfomon;
        this.battleType = battleType;
        playerCenfomon = Singleton.getInstance().getCurrentPlayer().getFirstCenfomon();
        battleScreenRenderer = new BattleScreenRenderer(batch, cenfomon);
        dialogueController = new DialogueController(j.getSkin());
        battleController = new BattleController(j.getSkin(), playerCenfomon, enemyCenfomon);
        endBattle = false;

        uiStage = new Stage(new ScreenViewport());
        uiStage.getViewport().update(Gdx.graphics.getWidth() / uiScale, Gdx.graphics.getHeight() / uiScale, true);
        uiStage.addActor(dialogueController.getTableRoot());
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
        updateHpBars();
        isEndBattle();
    }

    private void battle() {
        if(!endBattle) {
            battleController.showAttacks();
        } else {
            battleController.stopAttacks();
        }
    }

    private void updateHpBars() {
        opponentStatus.getHPBar().updateHpAmount(enemyCenfomon.getHealthAmount());
        opponentStatus.setHPText((int) enemyCenfomon.getHealthAmount(), 100);
        playerStatus.getHPBar().updateHpAmount(playerCenfomon.getHealthAmount());
        playerStatus.setHPText((int) playerCenfomon.getHealthAmount(), 100);
    }

    private void isEndBattle() {
        if(playerCenfomon.getHealthAmount() <= 0) {
            winnerDialogues();
            endBattle = true;
        } else if(enemyCenfomon.getHealthAmount() <= 0) {
            loserDialogues();
            endBattle = true;
        }
    }

    private void winnerDialogues() {
        DialogueNode node1 = new DialogueNode("Felicidades, haz ganado!", 0);
        dialogueController.addEndNode(node1);
        dialogueController.startDialogue();
    }

    private void loserDialogues() {
        DialogueNode node1 = new DialogueNode("Haz perdido, intentalo mas tarde.", 0);
        dialogueController.addEndNode(node1);
        dialogueController.startDialogue();
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
        playerStatus = new DetailedStatusBox(game.getSkin(), playerCenfomon);
        statusBoxRoot.add(playerStatus).expand().align(Align.left);
        statusBoxRoot.add(opponentStatus).expand().align(Align.right);
    }
}
