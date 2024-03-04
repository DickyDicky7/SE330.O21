package com.game.chess.boards.implementations;

public enum ChessBoardRow {
    R1(0),
    R2(1),
    R3(2),
    R4(3),
    R5(4),
    R6(5),
    R7(6),
    R8(7);

    public final int number;

    ChessBoardRow(int number) {
        this.number = number;
    }
}
