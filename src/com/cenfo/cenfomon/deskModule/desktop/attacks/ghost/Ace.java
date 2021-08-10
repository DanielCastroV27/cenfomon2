package com.cenfo.cenfomon.deskModule.desktop.attacks.ghost;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Ace extends Ability {

    public Ace() {
        super();
        setAbilityType(CenfomonType.GHOST);
        setDamagePoints(20);
        setDefensePoints(5);
        setName("As bajo la manga");
    }

    @Override
    public String getName() {
        return "As bajo la manga";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.defenseAndDamage(current, enemy, this);
    }
}
