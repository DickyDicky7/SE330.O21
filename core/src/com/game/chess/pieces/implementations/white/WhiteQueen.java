package com.game.chess.pieces.implementations.white;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.game.chess.MainAutoload;
import com.game.chess.pieces.abstractions.ChessPieceWhite;
import com.game.chess.pieces.abstractions.QueenBase;

public class WhiteQueen extends QueenBase implements ChessPieceWhite {
    public WhiteQueen() {
        super();
        this.sprite = new Sprite(MainAutoload.textureChessPieceWhiteQueen);
    }
}
