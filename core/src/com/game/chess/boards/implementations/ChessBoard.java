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
        this.init();
        this.sprite.setScale
                (MainAutoload.scale);
        float temp =
                (MainAutoload.scale - 1) * 0.5f;
        this.sprite.setPosition(this.sprite.getWidth() * temp, this.sprite.getHeight() * temp);
    }

    private void init() {
        this.init_Board(this._grid_);
        this.initSet1(this._grid_, new WhiteChessPiecesFactory(), ChessBoardRank.R1);
        this.initSet2(this._grid_, new WhiteChessPiecesFactory(), ChessBoardRank.R2);
        this.initSet2(this._grid_, new BlackChessPiecesFactory(), ChessBoardRank.R7);
        this.initSet1(this._grid_, new BlackChessPiecesFactory(), ChessBoardRank.R8);
        this.initTransform(this._grid_);
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

    private void initSet1(EnumMap<ChessBoardRank, EnumMap<ChessBoardFile, ChessPieceBase>> grid, ChessPiecesFactory chessPiecesFactory, ChessBoardRank chessBoardRank) {
        grid.get(chessBoardRank).put(ChessBoardFile.CD, chessPiecesFactory.createQueen());
        grid.get(chessBoardRank).put(ChessBoardFile.CE, chessPiecesFactory.createKing());
        grid.get(chessBoardRank).put(ChessBoardFile.CA, chessPiecesFactory.createRook());
        grid.get(chessBoardRank).put(ChessBoardFile.CH, chessPiecesFactory.createRook());
        grid.get(chessBoardRank).put(ChessBoardFile.CB, chessPiecesFactory.createKnight());
        grid.get(chessBoardRank).put(ChessBoardFile.CG, chessPiecesFactory.createKnight());
        grid.get(chessBoardRank).put(ChessBoardFile.CC, chessPiecesFactory.createBishop());
        grid.get(chessBoardRank).put(ChessBoardFile.CF, chessPiecesFactory.createBishop());
    }

    private void initSet2(EnumMap<ChessBoardRank, EnumMap<ChessBoardFile, ChessPieceBase>> grid, ChessPiecesFactory chessPiecesFactory, ChessBoardRank chessBoardRank) {
        grid.get(chessBoardRank).put(ChessBoardFile.CA, chessPiecesFactory.createPawn());
        grid.get(chessBoardRank).put(ChessBoardFile.CB, chessPiecesFactory.createPawn());
        grid.get(chessBoardRank).put(ChessBoardFile.CC, chessPiecesFactory.createPawn());
        grid.get(chessBoardRank).put(ChessBoardFile.CD, chessPiecesFactory.createPawn());
        grid.get(chessBoardRank).put(ChessBoardFile.CE, chessPiecesFactory.createPawn());
        grid.get(chessBoardRank).put(ChessBoardFile.CF, chessPiecesFactory.createPawn());
        grid.get(chessBoardRank).put(ChessBoardFile.CG, chessPiecesFactory.createPawn());
        grid.get(chessBoardRank).put(ChessBoardFile.CH, chessPiecesFactory.createPawn());
    }

    //@formatter:off
    private void initTransform(EnumMap<ChessBoardRank, EnumMap<ChessBoardFile, ChessPieceBase>> grid) {
            for (ChessBoardRank chessBoardRank : ChessBoardRank.values()) {
            for (ChessBoardFile chessBoardFile : ChessBoardFile.values()) {
                ChessPieceBase chessPiece = grid.get(chessBoardRank).get(chessBoardFile);
                if (chessPiece != null) {
                    chessPiece.getSprite().setScale (MainAutoload.scale);
                    chessPiece.getSprite().setOrigin(
                            - chessPiece.getSprite().getWidth () / 2 - 1.5f,
                            - chessPiece.getSprite().getHeight() / 2 + 4);
                    float x = chessBoardFile.number * chessPiece.getSprite().getWidth() * chessPiece.getSprite().getScaleX();
                    float y = chessBoardRank.number * chessPiece.getSprite().getWidth() * chessPiece.getSprite().getScaleY();
                    chessPiece.getSprite().setPosition( x , y );
                }
            }
        }
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        this.sprite.draw(spriteBatch);
            for (int k1 = ChessBoardRank.values().length - 1; k1 >= 0; --k1) {
            for (int k2 = ChessBoardFile.values().length - 1; k2 >= 0; --k2) {
                ChessBoardRank chessBoardRank = ChessBoardRank.values()[k1];
                ChessBoardFile chessBoardFile = ChessBoardFile.values()[k2];
                ChessPieceBase chessPiece = this._grid_.get(chessBoardRank).get(chessBoardFile);
                if (chessPiece != null) {
                    chessPiece.render(spriteBatch);
                }
            }
        }
    }
    //@formatter:on
}
