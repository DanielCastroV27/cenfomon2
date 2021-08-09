package com.cenfo.cenfomon.deskModule.desktop.attacks.bug;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
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
