package com.cenfo.cenfomon.deskModule.desktop.attacks.normal;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Lash extends Ability {

    public Lash() {
        super();
        setAbilityType(CenfomonType.NORMAL);
        setDamagePoints(25);
        setName("Azote");
    }

    @Override
    public String getName() {
        return "Azote";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
