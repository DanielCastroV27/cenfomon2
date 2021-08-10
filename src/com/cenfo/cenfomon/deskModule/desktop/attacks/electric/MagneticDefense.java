package com.cenfo.cenfomon.deskModule.desktop.attacks.electric;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Abilities;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class MagneticDefense extends Ability {

    public MagneticDefense() {
        super();
        setAbilityType(CenfomonType.ELECTRIC);
        setDamagePoints(10);
        setDefensePoints(10);
        setName("Defensa magnetica");
    }

    @Override
    public String getName() {
        return "Defensa magnetica";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        Abilities.defenseAndDamage(current, enemy, this);
    }
}
