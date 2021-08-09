package com.cenfo.cenfomon.deskModule.desktop.attacks.normal;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class Rampage extends Ability {

    public Rampage() {
        super();
        setAbilityType(CenfomonType.NORMAL);
        setDamagePoints(20);
        setName("Albotoro");
    }

    @Override
    public String getName() {
        return "Albotoro";
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
