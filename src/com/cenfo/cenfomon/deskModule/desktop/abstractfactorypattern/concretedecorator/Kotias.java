package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concretedecorator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.decorator.Decorator;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.water.Surf;
import com.cenfo.cenfomon.deskModule.desktop.attacks.water.WaterBomb;
import com.cenfo.cenfomon.deskModule.desktop.attacks.water.Waterjet;

public class Kotias extends Decorator {

    public Kotias(AbstractCenfomon cenfomon) {
        super();
        this.cenfomon = cenfomon;
        setType(CenfomonType.WATER);
        setName("Kotias");
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/cenfomon/kotias.png")));
        setHealthAmount(cenfomon.getHealthAmount() + 20);
    }

    @Override
    public void addAbilities() {
        getAbilities().add(new Surf());
        getAbilities().add(new Waterjet());
        getAbilities().add(new WaterBomb());
    }
}
