package com.game.chess.pieces.implementations.white;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.game.chess.MainAutoload;
import com.game.chess.pieces.abstractions.ChessPieceWhite;
import com.game.chess.pieces.abstractions.PawnBase;

public class WhitePawn extends PawnBase implements ChessPieceWhite {
    public WhitePawn() {
        super();
        this.sprite = new Sprite(MainAutoload.textureChessPieceWhitePawn);
    }
}
