package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractfactory;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.enums.CenfomonList;

public interface CenfomonAbstractFactory {
    AbstractCenfomon create(CenfomonList cenfomonType);

}
