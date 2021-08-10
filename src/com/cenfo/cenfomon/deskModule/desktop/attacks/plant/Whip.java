package com.cenfo.cenfomon.deskModule.desktop.attacks.plant;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Whip extends Ability {

    public Whip() {
        super();
        setAbilityType(CenfomonType.PLANT);
        setDamagePoints(20);
        setName("Latigo");
    }

    @Override
    public String getName() {
        return "Latigo";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
