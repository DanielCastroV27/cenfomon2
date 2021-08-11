package com.cenfo.cenfomon.deskModule.desktop.observer.interfaces;

public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
