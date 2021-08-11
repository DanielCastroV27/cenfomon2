package com.cenfo.cenfomon.deskModule.desktop.observer.concrete;

import com.cenfo.cenfomon.deskModule.desktop.Controllers.BattleController;
import com.cenfo.cenfomon.deskModule.desktop.Controllers.DialogueController;
import com.cenfo.cenfomon.deskModule.desktop.observer.interfaces.Observer;

public class ConcreteObserver implements Observer {

    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(DialogueController dialogueController, BattleController battleController) {
        dialogueController.startDialogue();
        battleController.stopAttacks();
    }
}
