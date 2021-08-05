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
            case "Osotias":
                cenfomon = factory.create(CenfomonList.OSOTIAS);
                break;

            case "Fenixluna":
                cenfomon = factory.create(CenfomonList.FENIXLUNA);
                break;
        }

        return cenfomon;
    }
}
