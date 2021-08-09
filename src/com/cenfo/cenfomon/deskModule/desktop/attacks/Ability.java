package com.cenfo.cenfomon.deskModule.desktop.attacks;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;

public abstract class Ability {
    private CenfomonType abilityType;
    private String name;
    private float damagePoints;
    private float defensePoints;
    private float healingPoints;

    public Ability() {

    }

    public CenfomonType getAbilityType() {
        return abilityType;
    }

    public void setAbilityType(CenfomonType abilityType) {
        this.abilityType = abilityType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(float damagePoints) {
        this.damagePoints = damagePoints;
    }

    public float getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(float defensePoints) {
        this.defensePoints = defensePoints;
    }

    public float getHealingPoints() {
        return healingPoints;
    }

    public void setHealingPoints(float healingPoints) {
        this.healingPoints = healingPoints;
    }

    public abstract String getName();

    public abstract void action(AbstractCenfomon current, AbstractCenfomon enemy);
}
