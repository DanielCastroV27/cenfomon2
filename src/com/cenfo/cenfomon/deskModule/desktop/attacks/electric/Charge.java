package com.cenfo.cenfomon.deskModule.desktop.attacks.electric;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Charge extends Ability {

    public Charge() {
        super();
        setAbilityType(CenfomonType.ELECTRIC);
        setDefensePoints(20);
        setName("Carga");
    }

    @Override
    public String getName() {
        return "Carga";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.defense(current, enemy, this);
    }
}
