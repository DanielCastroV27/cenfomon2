package com.cenfo.cenfomon.deskModule.desktop.attacks.electric;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class ElectricField extends Ability {

    public ElectricField() {
        super();
        setAbilityType(CenfomonType.ELECTRIC);
        setDamagePoints(15);
        setDefensePoints(15);
        setName("Campo electrico");
    }

    @Override
    public String getName() {
        return "Campo electrico";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.defenseAndDamage(current, enemy, this);
    }
}
