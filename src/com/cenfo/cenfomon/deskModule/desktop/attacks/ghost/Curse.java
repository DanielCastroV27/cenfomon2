package com.cenfo.cenfomon.deskModule.desktop.attacks.ghost;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Curse extends Ability {

    public Curse() {
        super();
        setAbilityType(CenfomonType.GHOST);
        setHealingPoints(20);
        setDamagePoints(25);
        setName("Maldicion");
    }

    @Override
    public String getName() {
        return "Maldicion";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.healingAndDamage(current, enemy, this);

    }
}
