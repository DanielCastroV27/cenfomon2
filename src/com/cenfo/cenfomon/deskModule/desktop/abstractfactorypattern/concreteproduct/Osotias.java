package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concreteproduct;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;

public class Osotias extends AbstractCenfomon {

    public Osotias() {
        super();
        setType(CenfomonType.WATER);
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/cenfomon/osotias.png")));
    }

    @Override
    public String getName() {
        return "Osotias";
    }
}
