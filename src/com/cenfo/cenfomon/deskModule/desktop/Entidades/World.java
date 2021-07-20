package com.cenfo.cenfomon.deskModule.desktop.Entidades;

import com.badlogic.gdx.math.GridPoint2;

import java.util.ArrayList;
import java.util.List;

public class World {
    private TileMap map;
    private List<Actor> actors;
    private List<WorldObject> worldObjects;

    public World(int width, int height) {
        this.map = new TileMap(width, height);
        actors = new ArrayList<>();
        worldObjects = new ArrayList<>();
    }

    public void addActor(Actor actor) {
        map.getTile(actor.getX(), actor.getY()).setActor(actor);
        this.actors.add(actor);
    }

    public void addObject(WorldObject worldObject) {
        for (GridPoint2 o : worldObject.getTiles()) {
            map.getTile(worldObject.getX() + o.x, worldObject.getY() + o.y).setWorldObject(worldObject);
        }
        this.worldObjects.add(worldObject);
    }

    public void update(float delta) {
        for(Actor a : this.actors) {
            a.Actualizar(delta);
        }

        for(WorldObject w : this.worldObjects) {
            w.update(delta);
        }
    }

    public TileMap getMap() {
        return map;
    }

    public void setMap(TileMap map) {
        this.map = map;
    }
}
