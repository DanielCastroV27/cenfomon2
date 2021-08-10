package com.cenfo.cenfomon.deskModule.desktop.attacks.fire;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class FireRing extends Ability {

    public FireRing() {
        super();
        setAbilityType(CenfomonType.FIRE);
        setDamagePoints(20);
        setName("Anillo de fuego");
    }

    @Override
    public String getName() {
        return "Anillo de fuego";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
