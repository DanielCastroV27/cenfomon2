package com.cenfo.cenfomon.deskModule.desktop.attacks.normal;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Pull extends Ability {

    public Pull() {
        super();
        setAbilityType(CenfomonType.NORMAL);
        setDamagePoints(25);
        setDefensePoints(5);
        setName("Atraccion");
    }

    @Override
    public String getName() {
        return "Atraccion";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.defenseAndDamage(current, enemy, this);
    }
}
