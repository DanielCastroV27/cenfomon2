package com.cenfo.cenfomon.deskModule.desktop.attacks.bug;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Defense extends Ability {

    public Defense() {
        super();
        setAbilityType(CenfomonType.BUG);
        setDefensePoints(20);
        setHealingPoints(5);
        setName("Defensa");
    }

    @Override
    public String getName() {
        return "Defensa";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
        current.setHealthAmount(current.getHealthAmount() + getHealingPoints());

        if(enemy.getDefensePoints() > 0) {
            float damagePointsLeft = getDamagePoints() - enemy.getDefensePoints();
            if(damagePointsLeft > 0) {
                enemy.setDefensePoints(0);
                enemy.setHealthAmount(enemy.getHealthAmount() - damagePointsLeft);
            }
        } else {
            enemy.setHealthAmount(enemy.getHealthAmount() - getDamagePoints());
        }
    }
}
