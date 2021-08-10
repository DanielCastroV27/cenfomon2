package com.cenfo.cenfomon.deskModule.desktop.attacks.ghost;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Shadow extends Ability {

    public Shadow() {
        super();
        setAbilityType(CenfomonType.GHOST);
        setDamagePoints(25);
        setName("Sombra");
    }

    @Override
    public String getName() {
        return "Sombra";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
