package com.cenfo.cenfomon.deskModule.desktop.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class HealthBar extends Widget {
    private Skin skin;

    private float hpAmount;
    private Table hp;

    private Drawable green;
    private Drawable yellow;
    private Drawable red;
    private Drawable background_hpbar;
    private Drawable hp_left;
    private Drawable hp_bar;

    private STATE state = STATE.IDLE;

    private float timer = 0f;
    private float animationDuration = 0f;

    private final float hpStart = 100;
    private final float hpEnd = 0;

    public HealthBar(Skin skin, float hpAmount) {
        super();
        this.skin = skin;
        this.hpAmount = hpAmount;

        green = skin.getDrawable("green");
        yellow = skin.getDrawable("yellow");
        red = skin.getDrawable("red");
        background_hpbar = skin.getDrawable("background_hpbar");
        hp_left = skin.getDrawable("hpbar_side");
        hp_bar = skin.getDrawable("hpbar_bar");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        int padLeft = 1;
        int padRight = 2;
        int padTop = 2;
        int padBottom = 2;

        float hpWidth = (hpAmount / 100) * (hp_bar.getMinWidth() - padLeft - padRight);

        Drawable hpColor = null;

        if(hpAmount <= hpStart && hpAmount > (hpStart / 2)) {
            hpColor = green;
        } else if(hpAmount <= (hpStart / 2) && hpAmount > hpEnd + 30) {
            hpColor = yellow;
        } else if(hpAmount <= hpEnd + 30) {
            hpColor = red;
        }

        hp_left.draw(batch, this.getX(), this.getY(), hp_left.getMinWidth(), hp_left.getMinHeight());

        background_hpbar.draw(batch, this.getX() + hp_left.getMinWidth() + padLeft, this.getY() + padBottom,
                hp_bar.getMinWidth() - padRight - padLeft, hp_bar.getMinHeight() - padTop-padBottom);

        hpColor.draw(batch, this.getX() + hp_left.getMinWidth() + padLeft, this.getY() + padBottom,
                hpWidth, hp_bar.getMinHeight() - padTop - padBottom);

        hp_bar.draw(batch, this.getX() + hp_left.getMinWidth(), this.getY(), hp_bar.getMinWidth(), hp_bar.getMinHeight());
    }

    @Override
    public float getMinHeight() {
        return hp_left.getMinHeight();
    }

    @Override
    public float getMinWidth() {
        return hp_left.getMinWidth() + hp_bar.getMinWidth();
    }

    public void updateHpAmount(int hp) {
        this.hpAmount = hp;
        hpAmount = (int) MathUtils.clamp(hpAmount, 0f, 1f);
    }
}
