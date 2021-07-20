package com.cenfo.cenfomon.deskModule.desktop.Entidades;

public class Tile {
    private TERRENO terreno;
    private Actor actor = null;
    private WorldObject worldObject;

    public Tile(TERRENO terreno) {
        this.terreno = terreno;
    }

    public TERRENO getTerreno() {
        return terreno;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public WorldObject getWorldObject() {
        return this.worldObject;
    }

    public void setWorldObject(WorldObject worldObject) {
        this.worldObject = worldObject;
    }

}