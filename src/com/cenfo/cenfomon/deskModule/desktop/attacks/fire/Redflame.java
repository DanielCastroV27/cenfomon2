package com.cenfo.cenfomon.deskModule.desktop.attacks.fire;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Redflame extends Ability {

    public Redflame() {
        super();
        setAbilityType(CenfomonType.FIRE);
        setDamagePoints(25);
        setName("Llama roja");
    }

    @Override
    public String getName() {
        return "Llama roja";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
