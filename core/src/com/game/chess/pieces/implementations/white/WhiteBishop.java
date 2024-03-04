package com.game.chess.pieces.implementations.white;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.game.chess.AutoloadSingleton;
import com.game.chess.pieces.abstractions.BishopBase;
import com.game.chess.pieces.abstractions.ChessPieceWhite;

public class WhiteBishop extends BishopBase implements ChessPieceWhite {
    public WhiteBishop() {
        super();
        this.sprite = new Sprite(AutoloadSingleton.textureChessPieceWhiteBishop);
    }
}
