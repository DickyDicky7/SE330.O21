package com.game.chess.factories.implementations;


import com.game.chess.factories.abstractions.ChessPiecesFactory;
import com.game.chess.pieces.abstractions.BishopBase;
import com.game.chess.pieces.abstractions.KingBase;
import com.game.chess.pieces.abstractions.KnightBase;
import com.game.chess.pieces.abstractions.PawnBase;
import com.game.chess.pieces.abstractions.QueenBase;
import com.game.chess.pieces.abstractions.RookBase;
import com.game.chess.pieces.implementations.white.WhiteBishop;
import com.game.chess.pieces.implementations.white.WhiteKing;
import com.game.chess.pieces.implementations.white.WhiteKnight;
import com.game.chess.pieces.implementations.white.WhitePawn;
import com.game.chess.pieces.implementations.white.WhiteQueen;
import com.game.chess.pieces.implementations.white.WhiteRook;

public class WhiteChessPiecesFactory implements ChessPiecesFactory {
    public WhiteChessPiecesFactory() {
        super();
    }

    @Override
    public PawnBase createPawn() {
        return new WhitePawn();
    }

    @Override
    public RookBase createRook() {
        return new WhiteRook();
    }

    @Override
    public KingBase createKing() {
        return new WhiteKing();
    }

    @Override
    public QueenBase createQueen() {
        return new WhiteQueen();
    }

    @Override
    public BishopBase createBishop() {
        return new WhiteBishop();
    }

    @Override
    public KnightBase createKnight() {
        return new WhiteKnight();
    }
}
