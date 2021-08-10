package com.cenfo.cenfomon.deskModule.desktop.attacks.bug;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class LifeSteal extends Ability {

    public LifeSteal() {
        super();
        setAbilityType(CenfomonType.BUG);
        setHealingPoints(15);
        setDamagePoints(15);
        setName("Chupa vidas");
    }

    @Override
    public String getName() {
        return "Chupa vidas";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.healingAndDamage(current, enemy, this);
    }
}
