package com.game.chess.boards.implementations;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.chess.Entity2DBase;
import com.game.chess.MainAutoload;
import com.game.chess.factories$.abstractions.ChessPiecesFactory;
import com.game.chess.factories$.implementations.BlackChessPiecesFactory;
import com.game.chess.factories$.implementations.WhiteChessPiecesFactory;
import com.game.chess.pieces.abstractions.ChessPieceBase;

import java.util.EnumMap;

public class ChessBoard extends Entity2DBase {
    private final EnumMap<ChessBoardRank, EnumMap<ChessBoardFile, ChessPieceBase>> _grid_;


    public ChessBoard() {
        super();
        this.sprite = new Sprite(MainAutoload.textureChessBoard);
        this._grid_ = new EnumMap<
                >(ChessBoardRank.class);
        init();
    }

    private void init() {
        init_Board(_grid_);
        initSet1(_grid_, new WhiteChessPiecesFactory(), ChessBoardRank.R1);
        initSet2(_grid_, new WhiteChessPiecesFactory(), ChessBoardRank.R2);
        initSet2(_grid_, new BlackChessPiecesFactory(), ChessBoardRank.R7);
        initSet1(_grid_, new BlackChessPiecesFactory(), ChessBoardRank.R8);
    }

    //@formatter:off
    private void init_Board(EnumMap<ChessBoardRank, EnumMap<ChessBoardFile, ChessPieceBase>> grid) {
            for (ChessBoardRank chessBoardRank : ChessBoardRank.values()) {
                grid.put(chessBoardRank, new EnumMap<>(ChessBoardFile.class));
            for (ChessBoardFile chessBoardFile : ChessBoardFile.values()) {
                grid.get(chessBoardRank).put(chessBoardFile, null);
            }
        }
    }
    //@formatter:on

    private void initSet1
            (EnumMap<ChessBoardRank, EnumMap<ChessBoardFile, ChessPieceBase>> grid, ChessPiecesFactory chessPiecesFactory, ChessBoardRank chessBoardRank) {
        grid.get(chessBoardRank).put(ChessBoardFile.CD, chessPiecesFactory.createQueen());
        grid.get(chessBoardRank).put(ChessBoardFile.CE, chessPiecesFactory.createKing());
        grid.get(chessBoardRank).put(ChessBoardFile.CA, chessPiecesFactory.createRook());
        grid.get(chessBoardRank).put(ChessBoardFile.CH, chessPiecesFactory.createRook());
        grid.get(chessBoardRank).put(ChessBoardFile.CB, chessPiecesFactory.createKnight());
        grid.get(chessBoardRank).put(ChessBoardFile.CG, chessPiecesFactory.createKnight());
        grid.get(chessBoardRank).put(ChessBoardFile.CC, chessPiecesFactory.createBishop());
        grid.get(chessBoardRank).put(ChessBoardFile.CF, chessPiecesFactory.createBishop());
    }

    private void initSet2
            (EnumMap<ChessBoardRank, EnumMap<ChessBoardFile, ChessPieceBase>> grid, ChessPiecesFactory chessPiecesFactory, ChessBoardRank chessBoardRank) {
        grid.get(chessBoardRank).put(ChessBoardFile.CA, chessPiecesFactory.createPawn());
        grid.get(chessBoardRank).put(ChessBoardFile.CB, chessPiecesFactory.createPawn());
        grid.get(chessBoardRank).put(ChessBoardFile.CC, chessPiecesFactory.createPawn());
        grid.get(chessBoardRank).put(ChessBoardFile.CD, chessPiecesFactory.createPawn());
        grid.get(chessBoardRank).put(ChessBoardFile.CE, chessPiecesFactory.createPawn());
        grid.get(chessBoardRank).put(ChessBoardFile.CF, chessPiecesFactory.createPawn());
        grid.get(chessBoardRank).put(ChessBoardFile.CG, chessPiecesFactory.createPawn());
        grid.get(chessBoardRank).put(ChessBoardFile.CH, chessPiecesFactory.createPawn());
    }

    public void testRender(SpriteBatch spriteBatch) {
        sprite.setScale(4);
        sprite.setPosition(sprite.getWidth() * 1.5f, sprite.getHeight() * 1.5f);
        sprite.draw(spriteBatch);
    }
}
