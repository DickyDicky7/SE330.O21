package com.game.chess;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.chess.boards.implementations.ChessBoard;

public class Main extends ApplicationAdapter {
    private ChessBoard chessBoard;
    private SpriteBatch spriteBatch;

    @Override
    public void create() {
        chessBoard = new ChessBoard();
        spriteBatch = new SpriteBatch();
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


        spriteBatch.begin();
        chessBoard.testRender(spriteBatch);
        spriteBatch.end();

    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
    }
}
