package com.game.chess.pieces.implementations.black;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.game.chess.AutoloadSingleton;
import com.game.chess.pieces.abstractions.ChessPieceBlack;
import com.game.chess.pieces.abstractions.QueenBase;

public class BlackQueen extends QueenBase implements ChessPieceBlack {
    public BlackQueen() {
        super();
        this.sprite = new Sprite(AutoloadSingleton.textureChessPieceBlackQueen);
    }
}
