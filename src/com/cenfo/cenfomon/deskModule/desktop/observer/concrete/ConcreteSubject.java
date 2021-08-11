package com.cenfo.cenfomon.deskModule.desktop.observer.concrete;

import com.cenfo.cenfomon.deskModule.desktop.Controllers.BattleController;
import com.cenfo.cenfomon.deskModule.desktop.Controllers.DialogueController;
import com.cenfo.cenfomon.deskModule.desktop.dialogues.DialogueNode;
import com.cenfo.cenfomon.deskModule.desktop.observer.interfaces.Observer;
import com.cenfo.cenfomon.deskModule.desktop.observer.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {

    private List<Observer> observers;
    DialogueController dialogueController;
    BattleController battleController;

    public ConcreteSubject(DialogueController dialogueController, BattleController battleController) {
        this.dialogueController = dialogueController;
        this.battleController = battleController;
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
    public void notifyObservers() {
        for(Observer o : observers) {
            o.update(dialogueController, battleController);
        }
    }

    public void isBattleFinished() {
        if(battleController.getPlayerCenfomon().getHealthAmount() <= 0) {
            DialogueNode node1 = new DialogueNode("Haz perdido, intentalo mas tarde.", 0);
            dialogueController.addEndNode(node1);
            notifyObservers();
        } else if(battleController.getEnemyCenfomon().getHealthAmount() <= 0) {
            DialogueNode node1 = new DialogueNode("Felicidades, haz ganado!", 0);
            dialogueController.addEndNode(node1);
            notifyObservers();
        } else {
            battleController.showAttacks();
        }
    }
}
