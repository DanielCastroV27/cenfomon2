package com.cenfo.cenfomon.deskModule.desktop.observer.interfaces;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;

public interface Observer {
    void update(AbstractCenfomon cenfomon);
}
