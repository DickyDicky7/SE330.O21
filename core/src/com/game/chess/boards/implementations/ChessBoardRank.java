package com.game.chess.boards.implementations;

public enum ChessBoardRank {
    R1(0),
    R2(1),
    R3(2),
    R4(3),
    R5(4),
    R6(5),
    R7(6),
    R8(7);

    public final int number;

    ChessBoardRank(int number) {
        this.number = number;
    }
}
