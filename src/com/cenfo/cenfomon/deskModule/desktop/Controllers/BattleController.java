package com.cenfo.cenfomon.deskModule.desktop.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;
import com.cenfo.cenfomon.deskModule.desktop.battle.AI;
import com.cenfo.cenfomon.deskModule.desktop.ui.OptionBox;

public class BattleController extends InputAdapter {

    private Stage uiStage;
    private Table tableRoot;
    private AbstractCenfomon playerCenfomon;
    private AbstractCenfomon enemyCenfomon;
    private OptionBox optionBox;
    private Ability lastPlayerAttack;
    private AI ai;

    public BattleController(Skin skin, AbstractCenfomon playerCenfomon, AbstractCenfomon enemyCenfomon) {
        this.playerCenfomon = playerCenfomon;
        this.enemyCenfomon = enemyCenfomon;
        uiStage = new Stage(new ScreenViewport());
        ai = new AI();
        int uiScale = 2;
        uiStage.getViewport().update(Gdx.graphics.getWidth() / uiScale, Gdx.graphics.getHeight() / uiScale, true);

        optionBox = new OptionBox(skin);
        optionBox.setVisible(false);

        tableRoot = new Table();
        tableRoot.setFillParent(true);
        uiStage.addActor(tableRoot);

        optionBox = new OptionBox(skin);
        optionBox.setVisible(false);

        Table dialogTable = new Table();
        dialogTable.add(optionBox)
                .expand()
                .align(Align.right)
                .space(8f)
                .row();

        tableRoot.add(dialogTable).expand().align(Align.bottom);
        addAtacks();
    }

    private void addAtacks() {
        for(Ability a : playerCenfomon.getAbilities()) {
            optionBox.addOption(a.getName());
        }
    }

    @Override
    public boolean keyUp(int keycode) {
        if (optionBox.isVisible()) {
            if (keycode == Input.Keys.I) {
                optionBox.moveUp();
                return true;
            } else if (keycode == Input.Keys.K) {
                optionBox.moveDown();
                return true;
            } else if(keycode == Input.Keys.ENTER) {
                optionBox.setVisible(false);
                attack(optionBox.getSelectedOption());
                enemyAttack();
                return true;
            }
        }

        return false;
    }

    private void attack(String abilityName) {
        Ability ability = playerCenfomon.getAbilities().stream().filter(a -> {
            return a.getName().equals(abilityName);
        }).findFirst().get();

        ability.action(playerCenfomon, enemyCenfomon);
        lastPlayerAttack = ability;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    public void showAttacks() {
        optionBox.setVisible(true);
    }

    public void stopAttacks() {
        optionBox.setVisible(false);
    }

    public void enemyAttack() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ai.setEnemyCenfomon(enemyCenfomon);
        ai.setUsedPlayerAbility(lastPlayerAttack);
        ai.setPlayerCenfomon(playerCenfomon);
        ai.attack();
    }

    public AbstractCenfomon getPlayerCenfomon() {
        return playerCenfomon;
    }

    public void setPlayerCenfomon(AbstractCenfomon playerCenfomon) {
        this.playerCenfomon = playerCenfomon;
    }

    public AbstractCenfomon getEnemyCenfomon() {
        return enemyCenfomon;
    }

    public void setEnemyCenfomon(AbstractCenfomon enemyCenfomon) {
        this.enemyCenfomon = enemyCenfomon;
    }

    public Table getTableRoot() {
        return tableRoot;
    }

    public void setTableRoot(Table tableRoot) {
        this.tableRoot = tableRoot;
    }
}
