package com.cenfo.cenfomon.deskModule.desktop.observer.concrete;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.observer.interfaces.Observer;

public class ConcreteObserver implements Observer {

    private String cenfomonName;

    public ConcreteObserver(String cenfomonName) {
        this.cenfomonName = cenfomonName;
    }

    @Override
    public void update(AbstractCenfomon cenfomon) {
        //actor.decorar(cenfomon);
    }
}
