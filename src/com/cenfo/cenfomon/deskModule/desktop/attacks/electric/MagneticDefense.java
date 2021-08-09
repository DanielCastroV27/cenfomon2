package com.cenfo.cenfomon.deskModule.desktop.attacks.electric;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
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
        current.setDefensePoints(current.getDefensePoints() + getDefensePoints());

        if (enemy.getDefensePoints() > 0) {
            float damagePointsLeft = getDamagePoints() - enemy.getDefensePoints();
            if (damagePointsLeft > 0) {
                enemy.setDefensePoints(0);
                enemy.setHealthAmount(enemy.getHealthAmount() - damagePointsLeft);
            }
        } else {
            enemy.setHealthAmount(enemy.getHealthAmount() - getDamagePoints());
        }
    }
}
