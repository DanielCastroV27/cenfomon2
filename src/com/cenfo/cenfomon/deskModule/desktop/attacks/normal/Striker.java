package com.cenfo.cenfomon.deskModule.desktop.attacks.normal;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Striker extends Ability {

    public Striker() {
        super();
        setAbilityType(CenfomonType.NORMAL);
        setDamagePoints(20);
        setName("Ariete");
    }

    @Override
    public String getName() {
        return "Ariete";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
