package com.cenfo.cenfomon.deskModule.desktop.attacks.water;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class AqueousDefense extends Ability {

    public AqueousDefense() {
        super();
        setAbilityType(CenfomonType.WATER);
        setHealingPoints(5);
        setDefensePoints(10);
        setName("Defensa Acuosa");
    }

    @Override
    public String getName() {
        return "Defensa Acuosa";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        current.setHealthAmount(current.getHealthAmount() + getHealingPoints());
        current.setDefensePoints(current.getDefensePoints() + getDefensePoints());
    }
}
