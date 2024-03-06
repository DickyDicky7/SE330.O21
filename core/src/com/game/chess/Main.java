package com.game.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.chess.boards.implementations.ChessBoard;

public class Main extends com.badlogic.gdx.ApplicationAdapter {
    //@formatter:off
    private ChessBoard chessBoard;private SpriteBatch spriteBatch;
    //@formatter:on

    @Override
    public void create() {
        //@formatter:off
        chessBoard = new ChessBoard();spriteBatch = new SpriteBatch();
        //@formatter:on
    }

    //@formatter:off
    @Override
    public void render() {
        Gdx.gl.glViewport(
                0,
                0,
                Gdx.graphics.getWidth (),
                Gdx.graphics.getHeight());
        Gdx.gl.glClear(com.badlogic.gdx.graphics.GL32
                .GL_COLOR_BUFFER_BIT
                | com.badlogic.gdx.graphics.GL32
                .GL_DEPTH_BUFFER_BIT
                | com.badlogic.gdx.graphics.GL32
                .GL_COVERAGE_BUFFER_BIT_NV);

        chessBoard.handle();
        chessBoard.update();
        spriteBatch.begin();chessBoard.render(spriteBatch);spriteBatch.end();

        System.out.println(
                chessBoard.getChessBoardFileBasedOnMousePositionX()
        + " " +
                chessBoard.getChessBoardRankBasedOnMousePositionY());
    }
    //@formatter:on

    @Override
    public void dispose() {
        spriteBatch.dispose();
    }
}
