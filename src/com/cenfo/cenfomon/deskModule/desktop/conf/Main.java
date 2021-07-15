package com.cenfo.cenfomon.deskModule.desktop.conf;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title="CENFOMON";
        config.height = Juego.HEIGHT;
        config.width = Juego.WIDTH;
        config.vSyncEnabled=true;
        config.resizable = false;
        new LwjglApplication(new Juego(), config);
    }
}
