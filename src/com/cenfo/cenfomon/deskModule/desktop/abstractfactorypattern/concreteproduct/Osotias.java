package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concreteproduct;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;
import com.cenfo.cenfomon.deskModule.desktop.attacks.water.AqueousDefense;
import com.cenfo.cenfomon.deskModule.desktop.attacks.water.Bubble;
import com.cenfo.cenfomon.deskModule.desktop.attacks.water.WaterBath;

public class Osotias extends AbstractCenfomon {

    public Osotias() {
        super();
        setType(CenfomonType.WATER);
        setName("Osotias");
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/cenfomon/osotias.png")));
    }

    @Override
    public void addAbilities() {
        getAbilities().add(new Bubble());
        getAbilities().add(new AqueousDefense());
        getAbilities().add(new WaterBath());
    }

}
