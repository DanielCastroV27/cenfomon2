package com.cenfo.cenfomon.deskModule.desktop.attacks.normal;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Grip extends Ability {

    public Grip() {
        super();
        setAbilityType(CenfomonType.NORMAL);
        setDamagePoints(20);
        setName("Agarre");
    }

    @Override
    public String getName() {
        return "Agarre";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.defense(current, enemy, this);
    }
}
