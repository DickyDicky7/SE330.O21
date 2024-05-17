//@formatter:off

package com.mygdx.game.chess.engine.pieces;

public enum PieceType {
    PAWN("P", 100) {
    },
    ROOK("R", 500) {
    },
    KING("K", 10000) {
    },
    QUEEN("Q", 900) {
    },
    KNIGHT("N", 300) {
    },
    BISHOP("B", 300) {
    };

    private final String pieceName ;
    private final int    pieceValue;

    PieceType(final String pieceName, final int pieceValue) {

        this.pieceName  = pieceName ;
        this.pieceValue = pieceValue;
    }

    @Override
    public String toString() {
        return this.pieceName;
    }

    public int getPieceValue() {
        return this.pieceValue;
    }
}
