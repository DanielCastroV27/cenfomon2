package com.cenfo.cenfomon.deskModule.desktop.attacks.plant;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Spears extends Ability {

    public Spears() {
        super();
        setAbilityType(CenfomonType.PLANT);
        setDamagePoints(25);
        setName("Semillas drenaje");
    }

    @Override
    public String getName() {
        return "Lanzas";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.damage(current, enemy, this);
    }
}
