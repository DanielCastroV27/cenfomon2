package com.cenfo.cenfomon.deskModule.desktop.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;

import java.util.ArrayList;
import java.util.List;

public class OptionBox extends Table {

    private int selectorIndex = 0;

    private List<Image> arrows;
    private List<Label> options;
    private Table uiContainer;
    private String selectedOption;

    public OptionBox(Skin skin) {
        super(skin);
        arrows = new ArrayList<>();
        options = new ArrayList<>();
        this.setBackground("optionbox");
        uiContainer = new Table();
        this.add(uiContainer).pad(5f);
    }

    public void addOption(String option) {
        Label optionLabel = new Label(option, this.getSkin());
        options.add(optionLabel);
        Image selectorLabel = new Image(this.getSkin(), "arrow");
        selectorLabel.setScaling(Scaling.none);
        arrows.add(selectorLabel);
        selectorLabel.setVisible(false);

        if (selectorLabel == arrows.get(selectorIndex)) {
            selectorLabel.setVisible(true);
        }

        uiContainer.add(selectorLabel).expand().align(Align.left).space(5f);
        uiContainer.add(optionLabel)
                .expand()
                .align(Align.left)
                .space(8f);
        uiContainer.row();
    }

    public void moveUp() {
        selectorIndex--;
        if (selectorIndex < 0) {
            selectorIndex = 0;
        }
        setSelectedOption();
        for (int i = 0; i < arrows.size(); i++) {
            if (i == selectorIndex) {
                arrows.get(i).setVisible(true);
            } else {
                arrows.get(i).setVisible(false);
            }
        }
    }

    public void moveDown() {
        selectorIndex++;
        if (selectorIndex >= arrows.size()) {
            selectorIndex = arrows.size()-1;
        }
        setSelectedOption();
        for (int i = 0; i < arrows.size(); i++) {
            if (i == selectorIndex) {
                arrows.get(i).setVisible(true);
            } else {
                arrows.get(i).setVisible(false);
            }
        }
    }

    public void clearChoices() {
        uiContainer.clearChildren();
        options.clear();
        arrows.clear();
        selectorIndex = 0;
    }

    public int getIndex() {
        return selectorIndex;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    private void setSelectedOption() {
        selectedOption = options.get(selectorIndex).getText().toString();
    }
}
