package com.game.chess.pieces.implementations.white;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.game.chess.MainAutoload;
import com.game.chess.pieces.abstractions.ChessPieceWhite;
import com.game.chess.pieces.abstractions.RookBase;

public class WhiteRook extends RookBase implements ChessPieceWhite {
    public WhiteRook() {
        super();
        this.sprite = new Sprite(MainAutoload.textureChessPieceWhiteRook);
    }
}
