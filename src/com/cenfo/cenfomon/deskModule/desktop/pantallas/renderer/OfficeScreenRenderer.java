package com.cenfo.cenfomon.deskModule.desktop.pantallas.renderer;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.GridPoint2;
import com.cenfo.cenfomon.deskModule.desktop.Entidades.*;
import com.cenfo.cenfomon.deskModule.desktop.conf.Juego;
import com.cenfo.cenfomon.deskModule.desktop.conf.Settings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OfficeScreenRenderer {
    private World world;
    private AssetManager assetManager;
    private Sprite floorSprite;
    private List<Integer> renderedObjects = new ArrayList<>();
    private List<YSortable> forRendering = new ArrayList<>();
    private SpriteBatch batch;

    public OfficeScreenRenderer(AssetManager assetManager, World world, SpriteBatch batch) {
        this.assetManager = assetManager;
        this.world = world;
        this.batch = batch;
        this.floorSprite = new Sprite(new Texture("res/un_packed/indoor_tiles_shadow.png"));
    }

    public void render() {
        float worldStartX = Juego.WIDTH / 3.5f - 0 * Settings.SCALE_TILE_SIZE;
        float worldStartY = Juego.HEIGHT / 3 - 0 * Settings.SCALE_TILE_SIZE;

        for (int x = 0; x < world.getMap().getWidth(); x++) {
            for (int y = 0; y < world.getMap().getHeight(); y++) {
                batch.draw(this.floorSprite,
                        worldStartX + x * Settings.SCALE_TILE_SIZE,
                        worldStartY + y * Settings.SCALE_TILE_SIZE,
                        Settings.SCALE_TILE_SIZE,
                        Settings.SCALE_TILE_SIZE);
            }
        }

        for (int x = 0; x < world.getMap().getWidth(); x++) {
            for (int y = 0; y < world.getMap().getHeight(); y++) {
                if (world.getMap().getTile(x, y).getActor() != null) {
                    Actor actor = world.getMap().getTile(x, y).getActor();
                    forRendering.add(actor);
                }
                if (world.getMap().getTile(x, y).getWorldObject() != null) {
                    WorldObject object = world.getMap().getTile(x, y).getWorldObject();
                    if (renderedObjects.contains(object.hashCode())) {
                        continue;
                    }
                    forRendering.add(object);
                    renderedObjects.add(object.hashCode());
                }
                if (world.getMap().getTile(x, y).getActor() != null) {
                    Actor actor = world.getMap().getTile(x, y).getActor();
                    forRendering.add(actor);
                }
            }

        }

        Collections.sort(forRendering, new WorldObjectYComparator());
        Collections.reverse(forRendering);

        for (YSortable loc : this.forRendering) {
            batch.draw(loc.getSprite(),
                    worldStartX + loc.getWorldX() * Settings.SCALED_TILE_SIZE,
                    worldStartY + loc.getWorldY() * Settings.SCALED_TILE_SIZE,
                    Settings.SCALED_TILE_SIZE * loc.getSizeX(),
                    Settings.SCALED_TILE_SIZE * loc.getSizeY());
        }

        this.addDoor();
        this.addTeacher();
    }

    private void addDoor() {
        Sprite doorSprite = new Sprite(new Texture("res/un_packed/labDoor.png"));
        GridPoint2 gridPoint2 = new GridPoint2(8, 0);
        WorldObject worldObject = new WorldObject(8, 0, false, doorSprite, 1.5f, 1.5f, new GridPoint2[]{gridPoint2});
        this.world.addObject(worldObject);
    }

    private void addTeacher() {
        Sprite teacherSprite = new Sprite(new Texture("res/un_packed/fonseca-no-bg.png"));
        GridPoint2 gridPoint2 = new GridPoint2(1, 8);
        WorldObject worldObject = new WorldObject(1, 8, false, teacherSprite, 1f, 1.6f, new GridPoint2[]{gridPoint2});
        this.world.addObject(worldObject);
    }
}
