package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concreteproduct;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concretedecorator.Corderion;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.normal.Grip;
import com.cenfo.cenfomon.deskModule.desktop.attacks.normal.Rampage;
import com.cenfo.cenfomon.deskModule.desktop.attacks.normal.Striker;

public class Corder extends AbstractCenfomon {

    public Corder() {
        super(10);
        setType(CenfomonType.NORMAL);
        setName("Corder");
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/cenfomon/corder.png")));
    }

    @Override
    public void addAbilities() {
        getAbilities().add(new Grip());
        getAbilities().add(new Rampage());
        getAbilities().add(new Striker());
    }

    @Override
    public AbstractCenfomon levelUp() {
        return new Corderion(this);
    }
}
