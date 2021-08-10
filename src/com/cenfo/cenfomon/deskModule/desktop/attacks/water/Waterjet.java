package com.cenfo.cenfomon.deskModule.desktop.attacks.water;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Waterjet extends Ability {

    public Waterjet() {
        super();
        setAbilityType(CenfomonType.WATER);
        setDamagePoints(25);
        setName("Chorro de agua");
    }

    @Override
    public String getName() {
        return "Chorro de agua";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
