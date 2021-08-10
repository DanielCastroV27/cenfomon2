package com.cenfo.cenfomon.deskModule.desktop.attacks.water;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Bubble extends Ability {

    public Bubble() {
        super();
        setAbilityType(CenfomonType.WATER);
        setDamagePoints(10);
        setDefensePoints(5);
        setName("Burbuja");
    }

    @Override
    public String getName() {
        return "Burbuja";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.defenseAndDamage(current, enemy, this);
    }
}
