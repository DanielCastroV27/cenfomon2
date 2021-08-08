package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;

public abstract class AbstractCenfomon {
    private int level;
    private float healthAmount;
    private CenfomonType type;
    private CenfomonType secondType;
    private Sprite cenfomonSprite;
    private int experiencePoints;

    public AbstractCenfomon() {
        level = 0;
        healthAmount = 100;
        experiencePoints = 0;
        secondType = null;
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

    public abstract String getName();
}
