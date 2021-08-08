package com.cenfo.cenfomon.deskModule.desktop.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;

public class StatusBox extends Table {

    private Label text;
    private HealthBar hpbar;

    protected Table uiContainer;

    public StatusBox(Skin skin, AbstractCenfomon cenfomon) {
        super(skin);
        this.setBackground("battleinfobox");
        uiContainer = new Table();
        this.add(uiContainer).pad(10f).expand().fill();

        text = new Label(cenfomon.getName(), skin, "smallLabel");
        text.setFontScale(2);
        uiContainer.add(text).align(Align.left).padTop(0f).padBottom(1f).row();

        hpbar = new HealthBar(skin, cenfomon.getHealthAmount());
        uiContainer.add(hpbar).spaceTop(0f).expand().fill();
    }

    public void setText(String newText) {
        text.setText(newText);
    }

    public HealthBar getHPBar() {
        return hpbar;
    }
}
