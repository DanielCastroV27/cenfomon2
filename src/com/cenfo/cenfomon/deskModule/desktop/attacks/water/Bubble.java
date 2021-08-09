package com.cenfo.cenfomon.deskModule.desktop.attacks.water;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Bubble extends Ability {

    public Bubble() {
        super();
        setAbilityType(CenfomonType.WATER);
        setDamagePoints(10);
        setDefensePoints(5);
        setName("Burbuja");
    }

    @Override
    public String getName() {
        return "Burbuja";
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
