package com.cenfo.cenfomon.deskModule.desktop.attacks.plant;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class SwirlPetals extends Ability {

    public SwirlPetals() {
        super();
        setAbilityType(CenfomonType.PLANT);
        setDamagePoints(20);
        setName("Petalos remolino");
    }

    @Override
    public String getName() {
        return "Petalos remolino";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
