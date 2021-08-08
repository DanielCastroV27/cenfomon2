package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concretefactory;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractfactory.CenfomonAbstractFactory;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concreteproduct.*;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonList;

public class CenfomonFactory implements CenfomonAbstractFactory {
    @Override
    public AbstractCenfomon create(CenfomonList cenfomonType) {
        AbstractCenfomon cenfomon = null;

        switch (cenfomonType) {
            case OSOTIAS:
                cenfomon = new Osotias();
                break;

            case FENIXLUNA:
                cenfomon = new FenixLuna();
                break;

            case ORUCROS:
                cenfomon = new Orucros();
                break;

            case CORDER:
                cenfomon = new Corder();
                break;

            case PAMO:
                cenfomon = new Pamo();
                break;

            case YENCORN:
                cenfomon = new Yencorn();
                break;
        }

        return cenfomon;
    }
}
