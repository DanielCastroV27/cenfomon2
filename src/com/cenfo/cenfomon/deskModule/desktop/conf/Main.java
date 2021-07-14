package com.cenfo.cenfomon.deskModule.desktop.conf;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title="Cenfomon java 1.8 prueba";
        config.height=400;
        config.width=600;
        config.vSyncEnabled=true;
        new LwjglApplication(new Juego(), config);
    }
}
