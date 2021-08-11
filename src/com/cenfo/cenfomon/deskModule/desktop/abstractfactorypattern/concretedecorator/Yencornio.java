package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concretedecorator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.decorator.Decorator;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.ghost.Curse;
import com.cenfo.cenfomon.deskModule.desktop.attacks.ghost.DarkBomb;
import com.cenfo.cenfomon.deskModule.desktop.attacks.ghost.ShadowStrike;

public class Yencornio extends Decorator {

    public Yencornio(AbstractCenfomon cenfomon) {
        super(16);
        this.cenfomon = cenfomon;
        setType(CenfomonType.GHOST);
        setName("Yencornio");
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/cenfomon/yencornio.png")));
        setHealthAmount(cenfomon.getHealthAmount() + 20);
    }

    @Override
    public void addAbilities() {
        getAbilities().add(new Curse());
        getAbilities().add(new DarkBomb());
        getAbilities().add(new ShadowStrike());
    }

    @Override
    public AbstractCenfomon levelUp() {
        return null;
    }
}
