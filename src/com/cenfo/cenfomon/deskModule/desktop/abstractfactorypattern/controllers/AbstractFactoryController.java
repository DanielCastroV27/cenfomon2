package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.controllers;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractfactory.CenfomonAbstractFactory;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.concretefactory.CenfomonFactory;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonList;

public class AbstractFactoryController {
    public AbstractCenfomon create(String option) {
        CenfomonAbstractFactory factory = new CenfomonFactory();
        AbstractCenfomon cenfomon = null;

        switch (option.toLowerCase()) {
            case "osotias":
                cenfomon = factory.create(CenfomonList.OSOTIAS);
                break;

            case "fenixluna":
                cenfomon = factory.create(CenfomonList.FENIXLUNA);
                break;

            case "orucros":
                cenfomon = factory.create(CenfomonList.ORUCROS);
                break;

            case "corder":
                cenfomon = factory.create(CenfomonList.CORDER);
                break;

            case "pamo":
                cenfomon = factory.create(CenfomonList.PAMO);
                break;

            case "yencorn":
                cenfomon = factory.create(CenfomonList.YENCORN);
                break;
        }

        return cenfomon;
    }
}
