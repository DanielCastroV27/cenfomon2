package com.cenfo.cenfomon.deskModule.desktop.attacks.electric;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class ElectricBall extends Ability {

    public ElectricBall() {
        super();
        setAbilityType(CenfomonType.ELECTRIC);
        setDamagePoints(20);
        setName("Bola electrica");
    }

    @Override
    public String getName() {
        return "Bola electrica";
    }

    @Override
    public void action(AbstractCenfomon current, AbstractCenfomon enemy) {
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
