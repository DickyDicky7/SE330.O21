package com.game.chess.boards.implementations;

public enum ChessBoardCol {
    CA(0),
    CB(1),
    CC(2),
    CD(3),
    CE(4),
    CF(5),
    CG(6),
    CH(7);

    public final int number;

    ChessBoardCol(int number) {
        this.number = number;
    }
}
