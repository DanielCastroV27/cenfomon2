package com.cenfo.cenfomon.deskModule.desktop.attacks.plant;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class DragonWhip extends Ability {

    public DragonWhip() {
        super();
        setAbilityType(CenfomonType.PLANT);
        setDamagePoints(25);
        setName("Latigo dragon");
    }

    @Override
    public String getName() {
        return "Latigo dragon";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
