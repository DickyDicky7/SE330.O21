package com.game.chess.factories$.implementations;

import com.game.chess.factories$.abstractions.ChessPiecesFactory;
import com.game.chess.pieces.abstractions.BishopBase;
import com.game.chess.pieces.abstractions.KingBase;
import com.game.chess.pieces.abstractions.KnightBase;
import com.game.chess.pieces.abstractions.PawnBase;
import com.game.chess.pieces.abstractions.QueenBase;
import com.game.chess.pieces.abstractions.RookBase;
import com.game.chess.pieces.implementations.black.BlackBishop;
import com.game.chess.pieces.implementations.black.BlackKing;
import com.game.chess.pieces.implementations.black.BlackKnight;
import com.game.chess.pieces.implementations.black.BlackPawn;
import com.game.chess.pieces.implementations.black.BlackQueen;
import com.game.chess.pieces.implementations.black.BlackRook;

public class BlackChessPiecesFactory implements ChessPiecesFactory {
    public BlackChessPiecesFactory() {
        super();
    }

    @Override
    public PawnBase createPawn() {
        return new BlackPawn();
    }

    @Override
    public RookBase createRook() {
        return new BlackRook();
    }

    @Override
    public KingBase createKing() {
        return new BlackKing();
    }

    @Override
    public QueenBase createQueen() {
        return new BlackQueen();
    }

    @Override
    public BishopBase createBishop() {
        return new BlackBishop();
    }

    @Override
    public KnightBase createKnight() {
        return new BlackKnight();
    }
}
