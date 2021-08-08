package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concreteproduct;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;

public class FenixLuna extends AbstractCenfomon {

    public FenixLuna() {
        super();
        setType(CenfomonType.FIRE);
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/cenfomon/fenixluna.png")));
    }

    @Override
    public String getName() {
        return "Fenixluna";
    }
}
