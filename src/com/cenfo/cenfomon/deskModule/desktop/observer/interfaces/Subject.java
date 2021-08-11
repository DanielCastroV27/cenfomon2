package com.cenfo.cenfomon.deskModule.desktop.observer.interfaces;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;

public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(AbstractCenfomon cenfomon);
}
