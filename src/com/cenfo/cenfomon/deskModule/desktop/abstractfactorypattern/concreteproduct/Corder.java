package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concreteproduct;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.normal.Grip;

public class Corder extends AbstractCenfomon {

    public Corder() {
        super();
        setType(CenfomonType.NORMAL);
        setName("Corder");
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/cenfomon/corder.png")));
    }

    @Override
    public void addAbilities() {
        getAbilities().add(new Grip());
    }
}
