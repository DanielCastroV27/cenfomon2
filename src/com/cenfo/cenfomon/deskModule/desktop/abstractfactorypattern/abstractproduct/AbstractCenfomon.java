package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;

public abstract class AbstractCenfomon implements Cloneable{
    private String name;
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

    private AbstractCenfomon(String name, int level, float healthAmount, CenfomonType type, CenfomonType secondType, Sprite cenfomonSprite, int experiencePoints) {
        this.name = name;
        this.level = level;
        this.healthAmount = healthAmount;
        this.type = type;
        this.secondType = secondType;
        this.cenfomonSprite = new Sprite(cenfomonSprite);
        this.experiencePoints = experiencePoints;
    }

    private AbstractCenfomon(AbstractCenfomon abstractCenfomon) {
        this.name = abstractCenfomon.name;
        this.level = abstractCenfomon.level;
        this.healthAmount = abstractCenfomon.healthAmount;
        this.type = abstractCenfomon.type;
        this.secondType = abstractCenfomon.secondType;
        this.cenfomonSprite = new Sprite(abstractCenfomon.cenfomonSprite);
        this.experiencePoints = abstractCenfomon.experiencePoints;
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

    @Override
    public final AbstractCenfomon clone() {
        try {
            return (AbstractCenfomon) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
