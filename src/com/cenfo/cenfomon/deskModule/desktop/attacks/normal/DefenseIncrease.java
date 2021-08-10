package com.cenfo.cenfomon.deskModule.desktop.attacks.normal;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class DefenseIncrease extends Ability {

    public DefenseIncrease() {
        super();
        setAbilityType(CenfomonType.NORMAL);
        setDefensePoints(25);
        setName("Incremento de defensa");
    }

    @Override
    public String getName() {
        return "Incremento de defensa";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.defense(current, enemy, this);
    }
}
