package com.mygdx.game.gui.gamemenu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.gui.GuiUtils;
import com.mygdx.game.gui.gamescreen.GameScreen;

public final class CancelButton extends TextButton {

    CancelButton(final GameScreen gameScreen, final Dialog dialog) {
        super("Cancel", GuiUtils.UI_SKIN);
        this.addListener(new ClickListener() {
            @Override
            public void clicked(final InputEvent event, final float x, final float y) {
                dialog.remove();
                gameScreen.getGameTimerPanel().continueTimer(true);
            }
        });
    }
}