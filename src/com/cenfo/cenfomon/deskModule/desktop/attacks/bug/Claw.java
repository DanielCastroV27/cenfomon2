package com.cenfo.cenfomon.deskModule.desktop.attacks.bug;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Claw extends Ability {

    public Claw() {
        super();
        setAbilityType(CenfomonType.BUG);
        setDamagePoints(25);
        setName("Garra");
    }

    @Override
    public String getName() {
        return "Garra";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
