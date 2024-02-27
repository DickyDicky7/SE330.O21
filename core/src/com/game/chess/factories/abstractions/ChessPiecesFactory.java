package com.game.chess.factories.abstractions;

import com.game.chess.pieces.abstractions.BishopBase;
import com.game.chess.pieces.abstractions.KingBase;
import com.game.chess.pieces.abstractions.KnightBase;
import com.game.chess.pieces.abstractions.PawnBase;
import com.game.chess.pieces.abstractions.QueenBase;
import com.game.chess.pieces.abstractions.RookBase;

public interface ChessPiecesFactory {
    PawnBase createPawn();

    RookBase createRook();

    KingBase createKing();

    QueenBase createQueen();

    BishopBase createBishop();

    KnightBase createKnight();
}
