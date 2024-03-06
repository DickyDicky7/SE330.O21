package com.game.chess.pieces.implementations.white;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.game.chess.MainAutoload;
import com.game.chess.pieces.abstractions.ChessPieceWhite;
import com.game.chess.pieces.abstractions.KingBase;

public class WhiteKing extends KingBase implements ChessPieceWhite {
    public WhiteKing() {
        super();
        this.sprite = new Sprite(MainAutoload.textureChessPieceWhiteKing);
    }
}
