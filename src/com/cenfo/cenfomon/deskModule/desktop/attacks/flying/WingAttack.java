package com.cenfo.cenfomon.deskModule.desktop.attacks.flying;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class WingAttack extends Ability {

    public WingAttack() {
        super();
        setAbilityType(CenfomonType.FLYING);
        setDamagePoints(20);
        setName("Ataque ala");
    }

    @Override
    public String getName() {
        return "Ataque ala";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
