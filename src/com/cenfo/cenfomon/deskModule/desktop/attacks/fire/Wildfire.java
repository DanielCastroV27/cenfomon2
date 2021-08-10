package com.cenfo.cenfomon.deskModule.desktop.attacks.fire;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Wildfire extends Ability {

    public Wildfire() {
        super();
        setAbilityType(CenfomonType.FIRE);
        setDamagePoints(25);
        setName("Fuego fatuo");
    }

    @Override
    public String getName() {
        return "Fuego fatuo";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
