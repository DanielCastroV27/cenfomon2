package com.cenfo.cenfomon.deskModule.desktop.attacks;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;

public class Abilities {

    public static void damage(AbstractCenfomon current, AbstractCenfomon enemy, Ability ability) {
        if (enemy.getDefensePoints() > 0) {
            float damagePointsLeft = ability.getDamagePoints() - enemy.getDefensePoints();
            if (damagePointsLeft > 0) {
                enemy.setDefensePoints(0);
                enemy.setHealthAmount(enemy.getHealthAmount() - damagePointsLeft);
            }
        } else {
            enemy.setHealthAmount(enemy.getHealthAmount() - ability.getDamagePoints());
        }
    }

    public static void defense(AbstractCenfomon current, AbstractCenfomon enemy, Ability ability) {
        current.setDefensePoints(current.getDefensePoints() + ability.getDefensePoints());
    }

    public static void defenseAndDamage(AbstractCenfomon current, AbstractCenfomon enemy, Ability ability) {
        current.setDefensePoints(current.getDefensePoints() + ability.getDefensePoints());

        if (enemy.getDefensePoints() > 0) {
            float damagePointsLeft = ability.getDamagePoints() - enemy.getDefensePoints();
            if (damagePointsLeft > 0) {
                enemy.setDefensePoints(0);
                enemy.setHealthAmount(enemy.getHealthAmount() - damagePointsLeft);
            }
        } else {
            enemy.setHealthAmount(enemy.getHealthAmount() - ability.getDamagePoints());
        }
    }

    public static void healingAndDamage(AbstractCenfomon current, AbstractCenfomon enemy, Ability ability) {
        current.setHealthAmount(current.getHealthAmount() + ability.getHealingPoints());

        if (enemy.getDefensePoints() > 0) {
            float damagePointsLeft = ability.getDamagePoints() - enemy.getDefensePoints();
            if (damagePointsLeft > 0) {
                enemy.setDefensePoints(0);
                enemy.setHealthAmount(enemy.getHealthAmount() - damagePointsLeft);
            }
        } else {
            enemy.setHealthAmount(enemy.getHealthAmount() - ability.getDamagePoints());
        }
    }

    public static void defenseAndHealing(AbstractCenfomon current, AbstractCenfomon enemy, Ability ability) {
        current.setHealthAmount(current.getHealthAmount() + ability.getHealingPoints());
        current.setDefensePoints(current.getDefensePoints() + ability.getDefensePoints());
    }
}
