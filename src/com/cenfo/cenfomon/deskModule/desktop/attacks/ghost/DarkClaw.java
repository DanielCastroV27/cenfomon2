package com.cenfo.cenfomon.deskModule.desktop.attacks.ghost;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

public class DarkClaw extends Ability {

    public DarkClaw() {
        super();
        setAbilityType(CenfomonType.GHOST);
        setDamagePoints(25);
        setName("Garra oscura");
    }

    @Override
    public String getName() {
        return "Garra oscura";
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