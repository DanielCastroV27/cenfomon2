package com.cenfo.cenfomon.deskModule.desktop.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.cenfo.cenfomon.deskModule.desktop.conf.Juego;

public class MainMenuScreen extends AbstractScreen{

    private static final int PLAY_BUTTON_WIDTH = 120;
    private static final int PLAY_BUTON_HEIGHT = 90;


    private static final int EXIT_BUTTON_WIDTH = 100;
    private static final int EXIT_BUTON_HEIGHT = 70;


    //Y axis
    private static final int EXIT_BUTTON_Y = 30;
    private static final int PLAY_BUTTON_Y = 100;


    private static final int LOGO_WIDTH = 400;
    private static final int LOGO_HEIGHT = 130;
    private static final int LOGO_Y = 210;

    Juego game;
    Texture exitButton;
    Texture playButton;
    Texture cenfomonLogo;
    TextureRegion background;

    public MainMenuScreen(Juego cenfomon) {
        super(cenfomon);
        this.game = cenfomon;
        this.playButton = new Texture("res/un_packed/play_button.png");
        this.exitButton = new Texture("res/un_packed/exit_button.png");
        this.cenfomonLogo = new Texture("res/un_packed/Cenfomon-logo.png");
        this.background = new TextureRegion(new Texture("res/un_packed/menu-bg.jpg"), 0, 0, Juego.WIDTH, Juego.HEIGHT);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        this.game.batch.begin();

        int playButtonX = Juego.WIDTH / 2 - PLAY_BUTTON_WIDTH / 2;
        int exitButtonX = Juego.WIDTH / 2 - EXIT_BUTTON_WIDTH / 2;
        int logoY = Juego.WIDTH / 2 - LOGO_WIDTH / 2;

        this.game.batch.draw(background, 0, 0);
        this.game.batch.draw(cenfomonLogo, logoY, LOGO_Y, LOGO_WIDTH, LOGO_HEIGHT);
        this.game.batch.draw(playButton, playButtonX, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTON_HEIGHT);
        this.game.batch.draw(exitButton, exitButtonX, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTON_HEIGHT);


        if(mouseClickedPlayButton(playButtonX)) {
            this.game.setScreen(new GameScreen(game));
        }

        if(mouseClickedExitButton(exitButtonX)) {
            Gdx.app.exit();
        }

        this.game.batch.end();
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

    private boolean mouseClickedPlayButton(int playButtonX) {
        boolean clicked = false;

        if(Gdx.input.getX() < playButtonX + PLAY_BUTTON_WIDTH && Gdx.input.getX() > playButtonX &&
                Juego.HEIGHT - Gdx.input.getY() < PLAY_BUTTON_Y + PLAY_BUTON_HEIGHT && Juego.HEIGHT - Gdx.input.getY() > PLAY_BUTTON_Y) {
            if(Gdx.input.isTouched()) {
                clicked = true;
            }
        }

        return clicked;
    }

    private boolean mouseClickedExitButton(int exitButtonX) {
        boolean clicked = false;

        if(Gdx.input.getX() < exitButtonX + EXIT_BUTTON_WIDTH && Gdx.input.getX() > exitButtonX &&
                Juego.HEIGHT - Gdx.input.getY() < EXIT_BUTTON_Y + EXIT_BUTON_HEIGHT && Juego.HEIGHT - Gdx.input.getY() > EXIT_BUTTON_Y) {
            if(Gdx.input.isTouched()) {
                clicked = true;
            }
        }

        return clicked;
    }
}