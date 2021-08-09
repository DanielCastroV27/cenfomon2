package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concreteproduct;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.electric.ElectricBall;
import com.cenfo.cenfomon.deskModule.desktop.attacks.electric.MagneticDefense;
import com.cenfo.cenfomon.deskModule.desktop.attacks.electric.StaticShock;

public class Pamo extends AbstractCenfomon {

    public Pamo() {
        super();
        setType(CenfomonType.ELECTRIC);
        setName("Pamo");
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/cenfomon/pamo.png")));
    }

    @Override
    public void addAbilities() {
        getAbilities().add(new StaticShock());
        getAbilities().add(new ElectricBall());
        getAbilities().add(new MagneticDefense());
    }

}
