package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concretedecorator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.decorator.Decorator;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.electric.Charge;
import com.cenfo.cenfomon.deskModule.desktop.attacks.electric.ElectricField;
import com.cenfo.cenfomon.deskModule.desktop.attacks.electric.ParabolaCharge;

public class Monan extends Decorator {

    public Monan(AbstractCenfomon cenfomon) {
        super(13);
        this.cenfomon = cenfomon;
        setType(CenfomonType.ELECTRIC);
        setName("Monan");
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/cenfomon/monan.png")));
        setHealthAmount(cenfomon.getHealthAmount() + 20);
    }

    @Override
    public void addAbilities() {
        getAbilities().add(new Charge());
        getAbilities().add(new ParabolaCharge());
        getAbilities().add(new ElectricField());
    }

    @Override
    public AbstractCenfomon levelUp() {
        return null;
    }
}
