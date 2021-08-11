package com.cenfo.cenfomon.deskModule.desktop.observer.concrete;

import com.cenfo.cenfomon.deskModule.desktop.abstractfactorypattern.abstractproduct.AbstractCenfomon;
import com.cenfo.cenfomon.deskModule.desktop.observer.interfaces.Observer;
import com.cenfo.cenfomon.deskModule.desktop.observer.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {

    private List<Observer> observers;

    public ConcreteSubject() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {

    }

    @Override
    public void notifyObservers(AbstractCenfomon cenfomon) {
        for(Observer o : observers) {
            o.update(cenfomon);
        }
    }

    public void decorate(AbstractCenfomon cenfomon) {

    }
}
