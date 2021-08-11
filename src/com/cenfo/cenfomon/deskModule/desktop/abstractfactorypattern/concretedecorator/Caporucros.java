package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concretedecorator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.decorator.Decorator;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.plant.DragonWhip;
import com.cenfo.cenfomon.deskModule.desktop.attacks.plant.DrainageSeeds;
import com.cenfo.cenfomon.deskModule.desktop.attacks.plant.Spears;

public class Caporucros extends Decorator {

    public Caporucros(AbstractCenfomon cenfomon) {
        super(8);
        this.cenfomon = cenfomon;
        setType(CenfomonType.PLANT);
        setSecondType(CenfomonType.BUG);
        setName("Caporucros");
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/cenfomon/caporucros.png")));
        setHealthAmount(cenfomon.getHealthAmount() + 20);
    }

    @Override
    public void addAbilities() {
        getAbilities().add(new DragonWhip());
        getAbilities().add(new DrainageSeeds());
        getAbilities().add(new Spears());
    }

    @Override
    public AbstractCenfomon levelUp() {
        return null;
    }
}
