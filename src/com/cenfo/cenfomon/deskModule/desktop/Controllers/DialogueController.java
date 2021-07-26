package com.cenfo.cenfomon.deskModule.desktop.Controllers;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;
import com.cenfo.cenfomon.deskModule.desktop.dialogues.Dialogue;
import com.cenfo.cenfomon.deskModule.desktop.dialogues.DialogueNode;
import com.cenfo.cenfomon.deskModule.desktop.dialogues.DialogueTraverser;
import com.cenfo.cenfomon.deskModule.desktop.dialogues.NODE_TYPE;
import com.cenfo.cenfomon.deskModule.desktop.ui.DialogueBox;
import com.cenfo.cenfomon.deskModule.desktop.ui.OptionBox;

public class DialogueController extends InputAdapter {

    private DialogueTraverser traverser;
    private DialogueBox dialogueBox;
    private OptionBox optionBox;
    private Dialogue dialogue;

    public DialogueController(DialogueBox box, OptionBox optionBox, Dialogue dialogue) {
        this.dialogueBox = box;
        this.optionBox = optionBox;
        this.dialogue = dialogue;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (dialogueBox.isVisible()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (optionBox.isVisible()) {
            if (keycode == Keys.I) {
                optionBox.moveUp();
                return true;
            } else if (keycode == Keys.K) {
                optionBox.moveDown();
                return true;
            }
        }
        if (traverser != null && keycode == Keys.ENTER && dialogueBox.isFinished()) {
            if (traverser.getType() == NODE_TYPE.END) {
                traverser = null;
                dialogueBox.setVisible(false);
            } else if (traverser.getType() == NODE_TYPE.LINEAR) {
                progress(0);
            } else if (traverser.getType() == NODE_TYPE.MULTIPLE_CHOICE) {
                progress(optionBox.getIndex());
            }
            return true;
        }
        if (dialogueBox.isVisible()) {
            return true;
        }
        return false;
    }

    public void makeLinear(DialogueNode node, int nextNodeId) {
        node.makeLinear(nextNodeId);
        dialogue.addNode(node);
    }

    public void addChoice(DialogueNode node, String option, int nextNodeId) {
        node.addChoice(option, nextNodeId);
        dialogue.addNode(node);
    }

    public void addEndNode(DialogueNode node) {
        dialogue.addNode(node);
    }

    public void update() {
        if (dialogueBox.isFinished() && traverser != null) {
            if (traverser.getType() == NODE_TYPE.MULTIPLE_CHOICE) {
                optionBox.setVisible(true);
            }
        }
    }

    public void startDialogue() {
        traverser = new DialogueTraverser(dialogue);
        dialogueBox.setVisible(true);
        dialogueBox.animateText(traverser.getText());
        if (traverser.getType() == NODE_TYPE.MULTIPLE_CHOICE) {
            optionBox.clear();
            for (String s : dialogue.getNode(dialogue.getStart()).getLabels()) {
                optionBox.addOption(s);
            }
        }
    }

    private void progress(int index) {
        optionBox.setVisible(false);
        DialogueNode nextNode = traverser.getNextNode(index);
        dialogueBox.animateText(nextNode.getText());
        if (nextNode.getType() == NODE_TYPE.MULTIPLE_CHOICE) {
            optionBox.clearChoices();
            for (String s : nextNode.getLabels()) {
                optionBox.addOption(s);
            }
        }
    }

    public String getSelectedOption() {
        return optionBox.getSelectedOption();
    }

    public boolean isDialogueShowing() {
        return dialogueBox.isVisible();
    }
}
