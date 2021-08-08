package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concreteproduct;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;

public class Corder extends AbstractCenfomon {

    public Corder() {
        super();
        setType(CenfomonType.NORMAL);
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/cenfomon/corder.png")));
    }

    @Override
    public String getName() {
        return "Corder";
    }
}
