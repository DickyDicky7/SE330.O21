package com.game.chess.pieces.implementations.black;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.game.chess.AutoloadSingleton;
import com.game.chess.pieces.abstractions.ChessPieceBlack;
import com.game.chess.pieces.abstractions.KingBase;

public class BlackKing extends KingBase implements ChessPieceBlack {
    public BlackKing() {
        super();
        this.sprite = new Sprite(AutoloadSingleton.textureChessPieceBlackKing);
    }
}
