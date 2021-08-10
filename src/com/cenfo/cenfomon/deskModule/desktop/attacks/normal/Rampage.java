package com.cenfo.cenfomon.deskModule.desktop.attacks.normal;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Rampage extends Ability {

    public Rampage() {
        super();
        setAbilityType(CenfomonType.NORMAL);
        setDamagePoints(20);
        setName("Albotoro");
    }

    @Override
    public String getName() {
        return "Albotoro";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
