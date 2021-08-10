package com.cenfo.cenfomon.deskModule.desktop.attacks.fire;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Whiteflame extends Ability {

    public Whiteflame() {
        super();
        setAbilityType(CenfomonType.FIRE);
        setDamagePoints(15);
        setDefensePoints(15);
        setName("Llama blanca");
    }

    @Override
    public String getName() {
        return "Llama blanca";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.defenseAndDamage(current, enemy, this);
    }
}
