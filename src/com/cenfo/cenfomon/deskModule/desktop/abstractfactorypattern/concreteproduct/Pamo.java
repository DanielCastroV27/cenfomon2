package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concreteproduct;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;

public class Pamo extends AbstractCenfomon {

    public Pamo() {
        super();
        setType(CenfomonType.ELECTRIC);
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/panantel.png")));

    }

    @Override
    public String getName() {
        return "Pamo";
    }
}
