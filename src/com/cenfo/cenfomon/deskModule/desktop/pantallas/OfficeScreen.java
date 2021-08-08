package com.cenfo.cenfomon.deskModule.desktop.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.cenfo.cenfomon.deskModule.desktop.Controllers.ControllerJugador;
import com.cenfo.cenfomon.deskModule.desktop.Controllers.DialogueController;
import com.cenfo.cenfomon.deskModule.desktop.Entidades.Actor;
import com.cenfo.cenfomon.deskModule.desktop.Entidades.TileMap;
import com.cenfo.cenfomon.deskModule.desktop.Entidades.World;
import com.cenfo.cenfomon.deskModule.desktop.Entidades.WorldObject;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.controllers.AbstractFactoryController;
import com.cenfo.cenfomon.deskModule.desktop.dialogues.DialogueNode;
import com.cenfo.cenfomon.deskModule.desktop.utilities.singleton.Singleton;
import com.cenfo.cenfomon.deskModule.desktop.conf.Juego;
import com.cenfo.cenfomon.deskModule.desktop.pantallas.renderer.OfficeScreenRenderer;

import java.awt.geom.Rectangle2D;

public class OfficeScreen extends AbstractScreen {
    private SpriteBatch batch;
    private Actor player;
    private World world;
    private OfficeScreenRenderer officeScreenRenderer;
    private Juego game;
    private Singleton singleton;

    private InputMultiplexer inputMultiplexer;
    private ControllerJugador playerController;
    private DialogueController dialogueController;
    private AbstractFactoryController factoryController;

    private Stage uiStage;
    private int uiScale = 2;
    private Viewport gameViewport;

    public OfficeScreen(Juego j) {
        super(j);
        game = j;
        batch = j.batch;
        singleton = Singleton.getInstance();
        gameViewport = new ScreenViewport();
        world = new World(10, 10);
        player = this.singleton.getCurrentPlayer();
        world.addActor(this.player);
        player.setMap(this.world.getMap());

        officeScreenRenderer = new OfficeScreenRenderer(j.getAssetManager(), this.world, this.batch);

        playerController = new ControllerJugador(player);

        //UI init
        dialogueController = new DialogueController(j.getSkin());
        uiStage = new Stage(new ScreenViewport());
        uiStage.getViewport().update(Gdx.graphics.getWidth() / uiScale, Gdx.graphics.getHeight() / uiScale, true);
        uiStage.addActor(dialogueController.getTableRoot());

        factoryController = new AbstractFactoryController();

        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(0, dialogueController);
        inputMultiplexer.addProcessor(1, playerController);

        initDialogues();
    }

    @Override
    public TileMap getMap() {
        return this.world.getMap();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public void render(float delta) {
        gameViewport.apply();

        batch.begin();
        officeScreenRenderer.render();
        batch.end();
        uiStage.draw();

        playerController.actualizarMovimiento(delta);
        world.update(delta);
        uiStage.act(delta);
        dialogueController.update();
        actorLeavesDoor();
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

    private void initDialogues() {
        if (!singleton.isActorEnteredOffice()) {
            singleton.setActorEnteredOffice(true);
            DialogueNode node1 = new DialogueNode("Hola, Cadete!\nBienvenido al planeta Cronos.", 0);
            DialogueNode node2 = new DialogueNode("Encontraras que la flora y la fauna son bastante\npeculiares por aca.", 1);
            DialogueNode node3 = new DialogueNode("Te asignare a un companero, escoge sabiamente.", 2);
            DialogueNode node4 = new DialogueNode("Haz escogido bien!", 3);
            DialogueNode node5 = new DialogueNode("Te entregare un chip con el que puedes ver la\n" +
                    "informacion de los cenfomones que captures.\n" +
                    "Puedes ver el menu de tus cenfomones con la tecla M.", 4);
            DialogueNode node6 = new DialogueNode("Mi comandante me ha informado que el equipo Magenta esta\n" +
                    "en el pueblo Badylet, tu primera mision es tratar de detenerlos!", 5);
            DialogueNode node7 = new DialogueNode("Antes de tu primera mision, recibiras un entrenamiento contra\n" +
                    "un androide llamado Robyt, asi podras conocer tus habilidades.", 6);
            DialogueNode node8 = new DialogueNode("Buena suerte, cadete!", 7);

            dialogueController.makeLinear(node1, node2.getID());
            dialogueController.makeLinear(node2, node3.getID());
            dialogueController.addChoice(node3, "Osotias", node4.getID());
            dialogueController.addChoice(node3, "Fenixluna", node4.getID());
            dialogueController.addChoice(node3, "Orucros", node4.getID());
            dialogueController.addChoice(node3, "Corder", node4.getID());
            dialogueController.addChoice(node3, "Pamo", node4.getID());
            dialogueController.addChoice(node3, "Yencorn", node4.getID());
            dialogueController.makeLinear(node4, node5.getID());
            dialogueController.makeLinear(node5, node6.getID());
            dialogueController.makeLinear(node6, node7.getID());
            dialogueController.makeLinear(node7, node8.getID());
            dialogueController.addEndNode(node8);
        } else {
            DialogueNode node1 = new DialogueNode("No hay nada nuevo por aca, Cadete!", 0);
            dialogueController.addEndNode(node1);
        }
        dialogueController.startDialogue();
    }

    private void actorLeavesDoor() {
        WorldObject w = world.getMap().getTile(8, 0).getWorldObject();
        Rectangle2D bounds = new Rectangle2D.Float(w.getX(), w.getY(), w.getSizeX(), w.getSizeY());
        AbstractScreen screen = singleton.getPreviousScreen();


        if (bounds.contains(player.getWorldX(), player.getWorldY()) && player.getFirstCenfomon() == null) {
            player.setFirstCenfomon(factoryController.create(dialogueController.getSelectedOption()));
            player.setFirstTraining(true);
            startTraining();
            player.setMap(screen.getMap());
            singleton.setPreviousScreen(this);

        } else if (bounds.contains(player.getWorldX(), player.getWorldY()) && player.getFirstCenfomon() != null) {
            singleton.setPreviousScreen(this);
            game.setScreen(screen);
        }
    }

    private void startTraining() {
        AbstractCenfomon enemyCenfomon = player.getFirstCenfomon().clone();
        enemyCenfomon.setName("Robyt");
        game.setScreen(new BattleScreen(game, enemyCenfomon, BattleType.TRAINING));
    }


}
