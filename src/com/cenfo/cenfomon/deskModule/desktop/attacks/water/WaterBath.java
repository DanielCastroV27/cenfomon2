package com.cenfo.cenfomon.deskModule.desktop.attacks.water;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class WaterBath extends Ability {

    public WaterBath() {
        super();
        setAbilityType(CenfomonType.WATER);
        setDamagePoints(20);
        setName("Bano Maria");
    }

    @Override
    public String getName() {
        return "Bano Maria";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
