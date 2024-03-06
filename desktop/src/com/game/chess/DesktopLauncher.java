package com.game.chess;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {
    public static void main(String[] arg) {
        int hCells = 14;
        int vCells = 9;
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setResizable(false);
        config.setWindowedMode(
                (int) (MainAutoload.SCALE * MainAutoload.CHESS_BOARD_CELL_W * hCells),
                (int) (MainAutoload.SCALE * MainAutoload.CHESS_BOARD_CELL_H * vCells));
        config.setForegroundFPS(60);
        config.setTitle("chess");
        config.setBackBufferConfig(8, 8, 8, 8, 16, 0, 4);
        new Lwjgl3Application(new Main(), config);
    }
}
