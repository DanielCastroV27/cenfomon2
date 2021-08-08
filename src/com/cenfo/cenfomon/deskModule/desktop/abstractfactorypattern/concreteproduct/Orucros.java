package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concreteproduct;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;

public class Orucros extends AbstractCenfomon {

    public Orucros() {
        super();
        setType(CenfomonType.PLANT);
        setSecondType(CenfomonType.BUG);
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/cenfomon/orucros.png")));
    }

    @Override
    public String getName() {
        return "Orucros";
    }
}
