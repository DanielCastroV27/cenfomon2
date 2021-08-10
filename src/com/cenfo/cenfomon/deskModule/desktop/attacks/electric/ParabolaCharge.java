package com.cenfo.cenfomon.deskModule.desktop.attacks.electric;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class ParabolaCharge extends Ability {

    public ParabolaCharge() {
        super();
        setAbilityType(CenfomonType.ELECTRIC);
        setDefensePoints(25);
        setDamagePoints(10);
        setName("Carga parabola");
    }

    @Override
    public String getName() {
        return "Carga parabola";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.defenseAndDamage(current, enemy, this);
    }
}
