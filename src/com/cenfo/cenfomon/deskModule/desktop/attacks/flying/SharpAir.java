package com.cenfo.cenfomon.deskModule.desktop.attacks.flying;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class SharpAir extends Ability {

    public SharpAir() {
        super();
        setAbilityType(CenfomonType.FLYING);
        setDamagePoints(25);
        setName("Aire afilado");
    }

    @Override
    public String getName() {
        return "Aire afilado";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
