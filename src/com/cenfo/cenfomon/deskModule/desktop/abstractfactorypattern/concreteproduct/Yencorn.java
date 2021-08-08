package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concreteproduct;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonType;

public class Yencorn extends AbstractCenfomon {

    public Yencorn() {
        super();
        setType(CenfomonType.GHOST);
        setName("Yencorn");
        setCenfomonSprite(new Sprite(new Texture("res/un_packed/cenfomon/yencorn.png")));
    }

}
