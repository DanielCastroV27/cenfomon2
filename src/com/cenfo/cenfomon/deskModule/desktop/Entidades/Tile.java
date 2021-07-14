package com.cenfo.cenfomon.deskModule.desktop.Entidades;

public class Tile {
    private TERRENO terreno;
    private Actor actor=null;

    public TERRENO getTerreno() {
        return terreno;
    }

    public Tile(TERRENO terreno) {
        this.terreno = terreno;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;

    }
}