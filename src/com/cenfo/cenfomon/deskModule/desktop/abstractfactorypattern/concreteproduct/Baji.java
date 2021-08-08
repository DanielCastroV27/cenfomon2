package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concreteproduct;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;

public class Baji extends AbstractCenfomon {

    public Baji() {
        super();
        setType(CenfomonType.BUG);
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/baji.png")));
    }

    @Override
    public String getName() {
        return "Baji";
    }
}
