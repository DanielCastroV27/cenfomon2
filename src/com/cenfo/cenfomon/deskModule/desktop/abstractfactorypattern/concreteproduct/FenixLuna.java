package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concreteproduct;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concretedecorator.SalamLuna;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.fire.Ember;
import com.cenfo.cenfomon.deskModule.desktop.attacks.fire.FireRing;
import com.cenfo.cenfomon.deskModule.desktop.attacks.fire.Flamethrower;

public class FenixLuna extends AbstractCenfomon {

    public FenixLuna() {
        super(4);
        setType(CenfomonType.FIRE);
        setName("FenixLuna");
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/cenfomon/fenixluna.png")));
    }

    @Override
    public void addAbilities() {
        getAbilities().add(new Ember());
        getAbilities().add(new FireRing());
        getAbilities().add(new Flamethrower());
    }

    @Override
    public AbstractCenfomon levelUp() {
        return new SalamLuna(this);
    }

}
