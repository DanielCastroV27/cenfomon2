package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.Ability;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCenfomon implements Cloneable{
    private String name;
    private int level;
    private float healthAmount;
    private float defensePoints;
    private CenfomonType type;
    private CenfomonType secondType;
    private Sprite cenfomonSprite;
    private int experiencePoints;
    private final List<Ability> abilities;

    public AbstractCenfomon() {
        level = 0;
        healthAmount = 100;
        defensePoints = 0;
        experiencePoints = 0;
        secondType = null;
        abilities = new ArrayList<>();
        addAbilities();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public CenfomonType getType() {
        return type;
    }

    public void setType(CenfomonType type) {
        this.type = type;
    }

    public CenfomonType getSecondType() {
        return secondType;
    }

    public void setSecondType(CenfomonType secondType) {
        this.secondType = secondType;
    }

    public Sprite getCenfomonSprite() {
        return cenfomonSprite;
    }

    public void setCenfomonSprite(Sprite cenfomonSprite) {
        this.cenfomonSprite = cenfomonSprite;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public float getHealthAmount() {
        return healthAmount;
    }

    public void setHealthAmount(float healthAmount) {
        this.healthAmount = healthAmount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public float getDefensePoints() {
        return defensePoints;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setDefensePoints(float defensePoints) {
        this.defensePoints = defensePoints;
    }

    public abstract void addAbilities();

    @Override
    public final AbstractCenfomon clone() {
        try {
            return (AbstractCenfomon) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


}
