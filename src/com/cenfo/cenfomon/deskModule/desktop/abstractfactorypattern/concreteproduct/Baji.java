package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concreteproduct;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.bug.Defense;

public class Baji extends AbstractCenfomon {

    public Baji() {
        super();
        super.setName("Baji");
        setType(CenfomonType.BUG);
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/cenfomon/baji.png")));
    }

    @Override
    public void addAbilities() {
        getAbilities().add(new Defense());
    }
}
