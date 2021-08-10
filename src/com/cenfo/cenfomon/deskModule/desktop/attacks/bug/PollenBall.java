package com.cenfo.cenfomon.deskModule.desktop.attacks.bug;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class PollenBall extends Ability {

    public PollenBall() {
        super();
        setAbilityType(CenfomonType.BUG);
        setDamagePoints(20);
        setName("Aguijon letal");
    }

    @Override
    public String getName() {
        return "Bola de polen";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
