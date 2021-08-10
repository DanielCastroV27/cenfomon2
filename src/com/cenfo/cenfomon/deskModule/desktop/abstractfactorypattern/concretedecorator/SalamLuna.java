package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concretedecorator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.decorator.Decorator;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.fire.Redflame;
import com.cenfo.cenfomon.deskModule.desktop.attacks.fire.Whiteflame;
import com.cenfo.cenfomon.deskModule.desktop.attacks.fire.Wildfire;

public class SalamLuna extends Decorator {

    public SalamLuna(AbstractCenfomon cenfomon) {
        super();
        this.cenfomon = cenfomon;
        setType(CenfomonType.FIRE);
        setName("Salamluna");
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/cenfomon/salamluna.png")));
        setHealthAmount(cenfomon.getHealthAmount() + 20);
    }

    @Override
    public void addAbilities() {
        getAbilities().add(new Redflame());
        getAbilities().add(new Whiteflame());
        getAbilities().add(new Wildfire());
    }
}
