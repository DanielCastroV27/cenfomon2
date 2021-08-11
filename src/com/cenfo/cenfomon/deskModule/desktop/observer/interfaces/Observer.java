package com.cenfo.cenfomon.deskModule.desktop.observer.interfaces;

import com.cenfo.cenfomon.deskModule.desktop.Controllers.BattleController;
import com.cenfo.cenfomon.deskModule.desktop.Controllers.DialogueController;

public interface Observer {
    void update(DialogueController dialogueController, BattleController battleController);
}
