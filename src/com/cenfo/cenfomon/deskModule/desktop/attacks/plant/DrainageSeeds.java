package com.cenfo.cenfomon.deskModule.desktop.attacks.plant;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class DrainageSeeds extends Ability {

    public DrainageSeeds() {
        super();
        setAbilityType(CenfomonType.PLANT);
        setDamagePoints(25);
        setName("Semillas drenaje");
    }

    @Override
    public String getName() {
        return "Semillas drenaje";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
