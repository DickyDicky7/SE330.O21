package com.game.chess.pieces.implementations.black;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.game.chess.AutoloadSingleton;
import com.game.chess.pieces.abstractions.BishopBase;
import com.game.chess.pieces.abstractions.ChessPieceBlack;

public class BlackBishop extends BishopBase implements ChessPieceBlack {
    public BlackBishop() {
        super();
        this.sprite = new Sprite(AutoloadSingleton.textureChessPieceBlackBishop);
    }
}
