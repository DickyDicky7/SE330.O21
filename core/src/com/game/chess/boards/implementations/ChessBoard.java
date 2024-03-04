package com.game.chess.boards.implementations;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.chess.AutoloadSingleton;
import com.game.chess.factories$.abstractions.ChessPiecesFactory;
import com.game.chess.factories$.implementations.BlackChessPiecesFactory;
import com.game.chess.factories$.implementations.WhiteChessPiecesFactory;

public class ChessBoard {
    private ChessPiecesFactory blackChessPiecesFactory;
    private ChessPiecesFactory whiteChessPiecesFactory;

    private final Sprite sprite;

    public ChessBoard() {
        super();
        blackChessPiecesFactory = new BlackChessPiecesFactory();
        whiteChessPiecesFactory = new WhiteChessPiecesFactory();

        sprite = new Sprite(AutoloadSingleton.textureChessBoard);
    }

    public void testRender(SpriteBatch spriteBatch) {
        sprite.setScale(4);
        sprite.setPosition(sprite.getWidth() * 1.5f, sprite.getHeight() * 1.5f);
        sprite.draw(spriteBatch);
    }
}
