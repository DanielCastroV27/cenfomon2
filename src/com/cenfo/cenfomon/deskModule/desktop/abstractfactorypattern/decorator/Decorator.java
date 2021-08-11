package com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.decorator;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;

public abstract class Decorator extends AbstractCenfomon {
    protected AbstractCenfomon cenfomon;

    public Decorator(int id) {
        super(id);
    }

    public AbstractCenfomon getCenfomon() {
        return cenfomon;
    }
}
