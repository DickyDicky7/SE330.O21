package com.game.chess.boards.implementations;

public enum ChessBoardFile {
    FA(0),
    FB(1),
    FC(2),
    FD(3),
    FE(4),
    FF(5),
    FG(6),
    FH(7);

    public final int number;

    ChessBoardFile(int number) {
        this.number = number;
    }
}
