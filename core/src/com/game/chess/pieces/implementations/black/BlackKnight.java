package com.game.chess.pieces.implementations.black;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.game.chess.MainAutoload;
import com.game.chess.pieces.abstractions.ChessPieceBlack;
import com.game.chess.pieces.abstractions.KnightBase;

public class BlackKnight extends KnightBase implements ChessPieceBlack {
    public BlackKnight() {
        super();
        this.sprite = new Sprite(MainAutoload.textureChessPieceBlackKnight);
    }
}
