package com.cenfo.cenfomon.deskModule.desktop.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.cenfo.cenfomon.deskModule.desktop.Controllers.ControllerJugador;
import com.cenfo.cenfomon.deskModule.desktop.Entidades.Actor;
import com.cenfo.cenfomon.deskModule.desktop.Entidades.World;
import com.cenfo.cenfomon.deskModule.desktop.Entidades.WorldObject;
import com.cenfo.cenfomon.deskModule.desktop.ui.DialogueBox;
import com.cenfo.cenfomon.deskModule.desktop.utilities.singleton.Singleton;
import com.cenfo.cenfomon.deskModule.desktop.conf.Juego;
import com.cenfo.cenfomon.deskModule.desktop.pantallas.renderer.OfficeScreenRenderer;
import java.awt.geom.Rectangle2D;

public class OfficeScreen extends AbstractScreen {
    private SpriteBatch batch;
    private Actor player;
    private ControllerJugador playerController;
    private World world;
    private OfficeScreenRenderer officeScreenRenderer;
    private Juego game;
    private Singleton singleton;
    private Stage uiStage;
    private Table tableRoot;
    private int uiScale = 2;
    private Viewport gameViewport;
    private DialogueBox dialogueBox;

    public OfficeScreen(Juego j) {
        super(j);
        this.game = j;
        this.batch = j.batch;
        this.singleton = Singleton.getInstance();
        this.gameViewport = new ScreenViewport();
        this.world = new World(10, 10);
        this.player = this.singleton.getCurrentPlayer();
        this.world.addActor(this.player);
        this.player.setMap(this.world.getMap());
        this.playerController = new ControllerJugador(player);
        this.officeScreenRenderer = new OfficeScreenRenderer(j.getAssetManager(), this.world, this.batch);

        this.initUI();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(playerController);
    }

    @Override
    public void render(float delta) {
        this.gameViewport.apply();
        this.playerController.actualizarMovimiento(delta);
        this.world.update(delta);

        this.uiStage.act(delta);

        this.batch.begin();
        this.officeScreenRenderer.render();
        this.batch.end();
        this.uiStage.draw();

        this.actorLeavesDoor();
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

    private void showDialogs(float delta) {
        this.dialogueBox.animateText("adw");
        this.uiStage.act(delta);
    }

    private void initUI() {
        this.uiStage = new Stage(new ScreenViewport());
        this.uiStage.getViewport().update(Gdx.graphics.getWidth() / this.uiScale, Gdx.graphics.getHeight() / this.uiScale, true);
        this.tableRoot = new Table();
        this.tableRoot.setFillParent(true);
        this.uiStage.addActor(this.tableRoot);
        this.game.getAssetManager().update();

        this.dialogueBox = new DialogueBox(this.game.getSkin());

        dialogueBox.animateText("Works!");

        this.tableRoot.add(dialogueBox)
                .expand()
                .align(Align.bottom)
                .pad(8f);

    }


    private void actorLeavesDoor() {
        WorldObject w = this.world.getMap().getTile(8, 0).getWorldObject();
        Rectangle2D bounds = new Rectangle2D.Float(w.getX(), w.getY(), w.getSizeX(), w.getSizeY());

        if (bounds.contains(this.player.getWorldX(), this.player.getWorldY())) {
            Screen screen = this.singleton.getPreviousScreen();
            this.singleton.setPreviousScreen(this);
            this.game.setScreen(screen);

            System.out.println("Works");
        }

    }

}
