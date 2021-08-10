package com.cenfo.cenfomon.deskModule.desktop.attacks.flying;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class ColdAir extends Ability {

    public ColdAir() {
        super();
        setAbilityType(CenfomonType.FLYING);
        setDamagePoints(15);
        setDefensePoints(15);
        setName("Aire frio");
    }

    @Override
    public String getName() {
        return "Aire frio";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.defenseAndDamage(current, enemy, this);
    }
}
