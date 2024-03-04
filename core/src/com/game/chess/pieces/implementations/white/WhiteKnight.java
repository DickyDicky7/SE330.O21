package com.game.chess.pieces.implementations.white;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.game.chess.AutoloadSingleton;
import com.game.chess.pieces.abstractions.ChessPieceWhite;
import com.game.chess.pieces.abstractions.KnightBase;

public class WhiteKnight extends KnightBase implements ChessPieceWhite {
    public WhiteKnight() {
        super();
        this.sprite = new Sprite(AutoloadSingleton.textureChessPieceWhiteKnight);
    }
}
