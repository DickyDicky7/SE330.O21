package com.game.chess.pieces.implementations.black;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.game.chess.MainAutoload;
import com.game.chess.pieces.abstractions.ChessPieceBlack;
import com.game.chess.pieces.abstractions.QueenBase;

public class BlackQueen extends QueenBase implements ChessPieceBlack {
    public BlackQueen() {
        super();
        this.sprite = new Sprite(MainAutoload.textureChessPieceBlackQueen);
    }
}
