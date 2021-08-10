package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concretedecorator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.decorator.Decorator;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.flying.ColdAir;
import com.cenfo.cenfomon.deskModule.desktop.attacks.flying.FastAttack;
import com.cenfo.cenfomon.deskModule.desktop.attacks.flying.SharpAir;

public class Ebrenum extends Decorator {

    public Ebrenum(AbstractCenfomon cenfomon) {
        super();
        this.cenfomon = cenfomon;
        setType(CenfomonType.FLYING);
        setName("Ebrenum");
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/cenfomon/ebrenum.png")));
        setHealthAmount(cenfomon.getHealthAmount() + 20);
    }

    @Override
    public void addAbilities() {
        getAbilities().add(new ColdAir());
        getAbilities().add(new FastAttack());
        getAbilities().add(new SharpAir());
    }
}
