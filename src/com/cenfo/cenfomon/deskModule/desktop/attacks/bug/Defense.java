package com.cenfo.cenfomon.deskModule.desktop.attacks.bug;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Defense extends Ability {

    public Defense() {
        super();
        setAbilityType(CenfomonType.BUG);
        setDefensePoints(10);
        setHealingPoints(5);
        setName("Defensa");
    }

    @Override
    public String getName() {
        return "Defensa";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.defenseAndHealing(current, enemy, this);
    }
}
