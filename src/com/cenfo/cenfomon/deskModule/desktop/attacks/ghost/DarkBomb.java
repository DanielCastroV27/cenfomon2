package com.cenfo.cenfomon.deskModule.desktop.attacks.ghost;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class DarkBomb extends Ability {

    public DarkBomb() {
        super();
        setAbilityType(CenfomonType.GHOST);
        setDamagePoints(30);
        setName("Bomba oscura");
    }

    @Override
    public String getName() {
        return "Bomba oscura";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
