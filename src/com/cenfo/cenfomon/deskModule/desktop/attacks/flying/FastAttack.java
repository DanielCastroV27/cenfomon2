package com.cenfo.cenfomon.deskModule.desktop.attacks.flying;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class FastAttack extends Ability {

    public FastAttack() {
        super();
        setAbilityType(CenfomonType.FLYING);
        setDamagePoints(25);
        setName("Ataque rapido");
    }

    @Override
    public String getName() {
        return "Ataque rapido";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
