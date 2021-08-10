package com.cenfo.cenfomon.deskModule.desktop.attacks.flying;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Flight extends Ability {

    public Flight() {
        super();
        setAbilityType(CenfomonType.FLYING);
        setDamagePoints(10);
        setDefensePoints(10);
        setName("Vuelo");
    }

    @Override
    public String getName() {
        return "Vuelo";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.defenseAndDamage(current, enemy, this);
    }
}
