package com.cenfo.cenfomon.deskModule.desktop.attacks.electric;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class StaticShock extends Ability {

    public StaticShock() {
        super();
        setAbilityType(CenfomonType.ELECTRIC);
        setDamagePoints(20);
        setName("Shock estatico");
    }

    @Override
    public String getName() {
        return "Shock estatico";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
