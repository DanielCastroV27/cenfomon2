package com.cenfo.cenfomon.deskModule.desktop.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;

public class DetailedStatusBox extends StatusBox{
    private Label hpText;

    public DetailedStatusBox(Skin skin, AbstractCenfomon cenfomon) {
        super(skin, cenfomon);

        hpText = new Label(cenfomon.getHealthAmount() + " de 100", skin, "smallLabel");
        setHPText((int) cenfomon.getHealthAmount(), 100);
        uiContainer.row();
        uiContainer.add(hpText).expand().right();
    }

    public void setHPText(int hpLeft, int hpTotal) {
        hpText.setText(hpLeft + " de " + hpTotal);
    }
}
