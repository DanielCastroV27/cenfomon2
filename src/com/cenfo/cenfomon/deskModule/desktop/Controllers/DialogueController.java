package com.cenfo.cenfomon.deskModule.desktop.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.cenfo.cenfomon.deskModule.desktop.dialogues.Dialogue;
import com.cenfo.cenfomon.deskModule.desktop.dialogues.DialogueNode;
import com.cenfo.cenfomon.deskModule.desktop.dialogues.DialogueTraverser;
import com.cenfo.cenfomon.deskModule.desktop.dialogues.NODE_TYPE;
import com.cenfo.cenfomon.deskModule.desktop.ui.DialogueBox;
import com.cenfo.cenfomon.deskModule.desktop.ui.OptionBox;

public class DialogueController extends InputAdapter {

    private DialogueTraverser traverser;

    private Stage uiStage;
    private Table tableRoot;
    private DialogueBox dialogueBox;
    private OptionBox optionBox;
    private Dialogue dialogue;
    private Skin gameSkin;

    public DialogueController(Skin gameSkin) {
        this.gameSkin = gameSkin;
        dialogue = new Dialogue();
        initUI();
    }

    private void initUI() {
        uiStage = new Stage(new ScreenViewport());
        int uiScale = 2;
        uiStage.getViewport().update(Gdx.graphics.getWidth() / uiScale, Gdx.graphics.getHeight() / uiScale, true);

        tableRoot = new Table();
        tableRoot.setFillParent(true);
        uiStage.addActor(tableRoot);

        dialogueBox = new DialogueBox(gameSkin);
        dialogueBox.setVisible(false);

        optionBox = new OptionBox(gameSkin);
        optionBox.setVisible(false);

        Table dialogTable = new Table();
        dialogTable.add(optionBox)
                .expand()
                .align(Align.right)
                .space(8f)
                .row();
        dialogTable.add(dialogueBox)
                .expand()
                .align(Align.bottom)
                .space(8f)
                .row();
        tableRoot.add(dialogTable).expand().align(Align.bottom);
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

    public Table getTableRoot() {
        return tableRoot;
    }
}
