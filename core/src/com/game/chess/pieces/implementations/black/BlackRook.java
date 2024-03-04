package com.game.chess.pieces.implementations.black;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.game.chess.AutoloadSingleton;
import com.game.chess.pieces.abstractions.ChessPieceBlack;
import com.game.chess.pieces.abstractions.RookBase;

public class BlackRook extends RookBase implements ChessPieceBlack {
    public BlackRook() {
        super();
        this.sprite = new Sprite(AutoloadSingleton.textureChessPieceBlackRook);
    }
}
