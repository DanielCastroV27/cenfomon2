package com.cenfo.cenfomon.deskModule.desktop.battle;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

import java.util.Collections;
import java.util.Comparator;

public class AI {

    private Ability usedPlayerAbility;
    private AbstractCenfomon enemyCenfomon;
    private AbstractCenfomon playerCenfomon;

    public AI() {
    }

    public void attack() {
        Ability abilityToUse = null;
        if(usedPlayerAbility.getHealingPoints() > 0 || usedPlayerAbility.getDefensePoints() > 0) {
            abilityToUse = Collections.max(enemyCenfomon.getAbilities(), Comparator.comparing(a -> a.getDamagePoints()));
        } else if (usedPlayerAbility.getHealingPoints() == 0 && usedPlayerAbility.getDefensePoints() == 0) {
            abilityToUse = Collections.min(enemyCenfomon.getAbilities(), Comparator.comparing(a -> a.getDamagePoints()));
        }

        abilityToUse.action(enemyCenfomon, playerCenfomon);
    }

    public void setUsedPlayerAbility(Ability usedPlayerAbility) {
        this.usedPlayerAbility = usedPlayerAbility;
    }

    public void setEnemyCenfomon(AbstractCenfomon enemyCenfomon) {
        this.enemyCenfomon = enemyCenfomon;
    }

    public void setPlayerCenfomon(AbstractCenfomon playerCenfomon) {
        this.playerCenfomon = playerCenfomon;
    }
}
