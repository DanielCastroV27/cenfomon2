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
            case "Bulbasaur":
                cenfomon = factory.create(CenfomonList.BULBASAUR);
                break;

            case "Slowpoke":
                cenfomon = factory.create(CenfomonList.SLOWPOKE);
                break;
        }

        return cenfomon;
    }
}
