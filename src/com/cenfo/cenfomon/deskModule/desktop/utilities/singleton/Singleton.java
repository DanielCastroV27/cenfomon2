package com.cenfo.cenfomon.deskModule.desktop.utilities.singleton;

import com.cenfo.cenfomon.deskModule.desktop.Entidades.Actor;
import com.cenfo.cenfomon.deskModule.desktop.pantallas.AbstractScreen;

public class Singleton {

    private static Singleton singleton;
    private Actor currentPlayer;
    private AbstractScreen previousScreen;
    private boolean actorEnteredOffice;


    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;
    }

    private Singleton() {
        actorEnteredOffice = false;
    }

    public Actor getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Actor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public AbstractScreen getPreviousScreen() {
        return previousScreen;
    }

    public void setPreviousScreen(AbstractScreen previousScreen) {
        this.previousScreen = previousScreen;
    }

    public boolean isActorEnteredOffice() {
        return actorEnteredOffice;
    }

    public void setActorEnteredOffice(boolean actorEnteredOffice) {
        this.actorEnteredOffice = actorEnteredOffice;
    }
}
