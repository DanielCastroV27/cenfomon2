package com.cenfo.cenfomon.deskModule.desktop.pantallas.renderer;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.conf.Juego;
import com.cenfo.cenfomon.deskModule.desktop.utilities.singleton.Singleton;

public class BattleScreenRenderer {
    private SpriteBatch batch;
    private TextureRegion battleTexture;
    private TextureRegion platform;
    private AbstractCenfomon enemyCenfomon;
    private AbstractCenfomon playerCenfomon;

    //Scene UI
    private final int platformWidth = 200;
    private final int platformHeight = 100;
    private final int platformY = (int) (Juego.HEIGHT / 2.5);
    private final int playerPlatformX = 150;
    private final int enemyPlatformX = 450;
    private final int cenfomonWidth = 256;
    private final int cenfomonHeight = 256;

    public BattleScreenRenderer(SpriteBatch batch, AbstractCenfomon cenfomon) {
        this.batch = batch;
        enemyCenfomon = cenfomon;
        playerCenfomon = Singleton.getInstance().getCurrentPlayer().getFirstCenfomon();
        battleTexture = new TextureRegion(new Texture("res/un_packed/battle/battle-background.png"));
        platform = new TextureRegion(new Texture("res/un_packed/battle/platform.png"));
    }

    public void render() {
        //Scene basic UI
        batch.draw(battleTexture, 0,0, Juego.WIDTH, Juego.HEIGHT);
        batch.draw(platform, playerPlatformX, platformY, platformWidth, platformHeight);
        batch.draw(platform, enemyPlatformX, platformY, platformWidth, platformHeight);

        //Cenfomon's sprites
        batch.draw(enemyCenfomon.getCenfomonSprite(), enemyPlatformX - 20, platformY + 5, cenfomonWidth, cenfomonHeight);
        batch.draw(playerCenfomon.getCenfomonSprite(), playerPlatformX - 20, platformY + 5, cenfomonWidth, cenfomonHeight);
    }
}
