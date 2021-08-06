package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concretefactory;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractfactory.CenfomonAbstractFactory;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concreteproduct.Osotias;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concreteproduct.FenixLuna;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonList;

public class CenfomonFactory implements CenfomonAbstractFactory {
    @Override
    public AbstractCenfomon create(CenfomonList cenfomonType) {
        AbstractCenfomon cenfomon = null;

        switch (cenfomonType) {
            case FENIXLUNA:
                cenfomon = new FenixLuna();
                break;

            case OSOTIAS:
                cenfomon = new Osotias();
                break;
        }

        return cenfomon;
    }
}
