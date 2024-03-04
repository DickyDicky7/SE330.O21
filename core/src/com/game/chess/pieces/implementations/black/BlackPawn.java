package com.game.chess.pieces.implementations.black;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.game.chess.AutoloadSingleton;
import com.game.chess.pieces.abstractions.ChessPieceBlack;
import com.game.chess.pieces.abstractions.PawnBase;

public class BlackPawn extends PawnBase implements ChessPieceBlack {
    public BlackPawn() {
        super();
        this.sprite = new Sprite(AutoloadSingleton.textureChessPieceBlackPawn);
    }
}
