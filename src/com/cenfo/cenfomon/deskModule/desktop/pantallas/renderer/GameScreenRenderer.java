package com.cenfo.cenfomon.deskModule.desktop.pantallas.renderer;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.GridPoint2;
import com.cenfo.cenfomon.deskModule.desktop.Entidades.*;
import com.cenfo.cenfomon.deskModule.desktop.conf.Juego;
import com.cenfo.cenfomon.deskModule.desktop.conf.Settings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameScreenRenderer {
    private World world;
    private AssetManager assetManager;
    private Texture grass1;
    private Texture grass2;
    private List<Integer> renderedObjects = new ArrayList<>();
    private List<YSortable> forRendering = new ArrayList<>();
    private SpriteBatch batch;
    private TextureAtlas houseAtlas;
    private Sprite houseRegion;

    public GameScreenRenderer(AssetManager assetManager, World world, SpriteBatch batch) {
        this.assetManager = assetManager;
        this.world = world;
        this.batch = batch;
        this.grass1 = new Texture("res/un_packed/grass1.png");
        this.grass2 = new Texture("res/un_packed/grass2.png");
        this.houseAtlas = this.assetManager.get("res/packed/textures.atlas", TextureAtlas.class);
        this.houseRegion = houseAtlas.createSprite("small_house");
    }

    public void render(Camara camera) {
        float worldStartX = Juego.WIDTH / 34 - camera.getCamaraX() * Settings.SCALE_TILE_SIZE;
        float worldStartY = Juego.HEIGHT / 270 - camera.getCamaraY() * Settings.SCALE_TILE_SIZE;

        for (int x = 0; x < world.getMap().getWidth(); x++) {
            for (int y = 0; y < world.getMap().getHeight(); y++) {
                Texture render;
                if (world.getMap().getTile(x, y).getTerreno() == TERRENO.GRASS_1) {
                    render = grass1;
                } else {
                    render = grass2;
                }
                batch.draw(render,
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

        this.addHouse();
        this.addTrees(camera);
    }


    private void addTrees(Camara camara) {
        TextureAtlas atlas = this.assetManager.get("res/packed/textures.atlas", TextureAtlas.class);
        TextureRegion treeRegion = atlas.findRegion("large_tree");
        float worldStartX = Juego.WIDTH / 34 - camara.getCamaraX() * Settings.SCALE_TILE_SIZE;
        float worldStartY = Juego.HEIGHT / 23 - camara.getCamaraY() * Settings.SCALE_TILE_SIZE;

        int mapWidth = this.world.getMap().getWidth();
        int mapHeight = this.world.getMap().getHeight();


        for (int i = 0; i < mapWidth; i++) {
            batch.draw(treeRegion,
                    worldStartX + i * Settings.SCALE_TILE_SIZE,
                    worldStartY + (mapHeight - 2) * Settings.SCALE_TILE_SIZE,
                    Settings.SCALE_TILE_SIZE,
                    Settings.SCALE_TILE_SIZE);

            batch.draw(treeRegion,
                    worldStartX + i * Settings.SCALE_TILE_SIZE,
                    worldStartY + -1 * Settings.SCALE_TILE_SIZE,
                    Settings.SCALE_TILE_SIZE,
                    Settings.SCALE_TILE_SIZE);
        }

        for (int i = 0; i < mapHeight - 1; i++) {
            batch.draw(treeRegion,
                    worldStartX + (mapWidth - 1) * Settings.SCALE_TILE_SIZE,
                    worldStartY + i * Settings.SCALE_TILE_SIZE,
                    Settings.SCALE_TILE_SIZE,
                    Settings.SCALE_TILE_SIZE);

            batch.draw(treeRegion,
                    worldStartX + 0 * Settings.SCALE_TILE_SIZE,
                    worldStartY + i * Settings.SCALE_TILE_SIZE,
                    Settings.SCALE_TILE_SIZE,
                    Settings.SCALE_TILE_SIZE);
        }
    }

    private void addHouse() {
        GridPoint2 gridPoint2 = new GridPoint2(5, 5);
        WorldObject worldObject = new WorldObject(5, 5, false, this.houseRegion, 5, 5, new GridPoint2[]{gridPoint2});
        this.world.addObject(worldObject);
    }
}
