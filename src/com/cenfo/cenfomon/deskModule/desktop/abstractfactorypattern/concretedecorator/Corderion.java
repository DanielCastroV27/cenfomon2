package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concretedecorator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.decorator.Decorator;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.normal.DefenseIncrease;
import com.cenfo.cenfomon.deskModule.desktop.attacks.normal.Lash;
import com.cenfo.cenfomon.deskModule.desktop.attacks.normal.Pull;

public class Corderion extends Decorator {

    public Corderion(AbstractCenfomon cenfomon) {
        super();
        this.cenfomon = cenfomon;
        setType(CenfomonType.NORMAL);
        setName("Corderion");
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/cenfomon/corderion.png")));
        setHealthAmount(cenfomon.getHealthAmount() + 20);
    }

    @Override
    public void addAbilities() {
        getAbilities().add(new DefenseIncrease());
        getAbilities().add(new Lash());
        getAbilities().add(new Pull());
    }
}
