package com.game.chess;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.chess.boards.implementations.ChessBoard;

public class Main extends ApplicationAdapter {
    //@formatter:off
    private ChessBoard chessBoard;private SpriteBatch spriteBatch;
    //@formatter:on

    @Override
    public void create() {
        //@formatter:off
        chessBoard = new ChessBoard();spriteBatch = new SpriteBatch();
        //@formatter:on
    }

    @Override
    public void render() {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20
                .GL_COLOR_BUFFER_BIT
                | GL20
                .GL_DEPTH_BUFFER_BIT
                | GL20
                .GL_COVERAGE_BUFFER_BIT_NV);

        //@formatter:off
        spriteBatch.begin();chessBoard.render(spriteBatch);spriteBatch.end();
        //@formatter:on
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
    }
}
