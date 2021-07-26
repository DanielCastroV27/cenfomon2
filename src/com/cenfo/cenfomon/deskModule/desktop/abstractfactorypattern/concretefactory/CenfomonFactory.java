package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concretefactory;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractfactory.CenfomonAbstractFactory;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concreteproduct.Bulbasaur;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concreteproduct.Slowpoke;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonList;

public class CenfomonFactory implements CenfomonAbstractFactory {
    @Override
    public AbstractCenfomon create(CenfomonList cenfomonType) {
        AbstractCenfomon cenfomon = null;

        switch (cenfomonType) {
            case SLOWPOKE:
                cenfomon = new Slowpoke();
                break;

            case BULBASAUR:
                cenfomon = new Bulbasaur();
                break;
        }

        return cenfomon;
    }
}
