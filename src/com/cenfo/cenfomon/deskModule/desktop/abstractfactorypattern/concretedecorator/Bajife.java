package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concretedecorator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.decorator.Decorator;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.bug.Claw;
import com.cenfo.cenfomon.deskModule.desktop.attacks.bug.FuryCut;
import com.cenfo.cenfomon.deskModule.desktop.attacks.bug.LifeSteal;

public class Bajife extends Decorator {

    public Bajife(AbstractCenfomon cenfomon) {
        super(20);
        this.cenfomon = cenfomon;
        super.setName("Bajife");
        setType(CenfomonType.BUG);
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/cenfomon/bajife.png")));
        setHealthAmount(cenfomon.getHealthAmount() + 20);
    }

    @Override
    public void addAbilities() {
        getAbilities().add(new Claw());
        getAbilities().add(new FuryCut());
        getAbilities().add(new LifeSteal());
    }

    @Override
    public AbstractCenfomon levelUp() {
        return null;
    }
}
