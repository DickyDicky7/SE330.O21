package com.game.chess.boards.implementations;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.chess.Entity2DBase;
import com.game.chess.MainAutoload;
import com.game.chess.factories$.abstractions.ChessPiecesFactory;
import com.game.chess.factories$.implementations.BlackChessPiecesFactory;
import com.game.chess.factories$.implementations.WhiteChessPiecesFactory;
import com.game.chess.pieces.abstractions.ChessPieceBase;

import java.util.*;

public class ChessBoard extends Entity2DBase {
    private final List<ChessPieceBase> chessPieces;

    public ChessBoard() {
        super();
        this.sprite = new Sprite(MainAutoload.textureChessBoard);
        chessPieces = new ArrayList<>();
        this.init();
    }

    private void init() {
        this.initSet1(this.chessPieces, new WhiteChessPiecesFactory(), ChessBoardRank.R1);
        this.initSet2(this.chessPieces, new WhiteChessPiecesFactory(), ChessBoardRank.R2);
        this.initSet2(this.chessPieces, new BlackChessPiecesFactory(), ChessBoardRank.R7);
        this.initSet1(this.chessPieces, new BlackChessPiecesFactory(), ChessBoardRank.R8);
        this.update();
    }

    //@formatter:off
    private void initSet1(List<ChessPieceBase> chessPieces, ChessPiecesFactory chessPiecesFactory, ChessBoardRank chessBoardRank) {
        for (ChessBoardFile chessBoardFile   :   ChessBoardFile.values()) {
             ChessPieceBase chessPiece = switch (chessBoardFile) {
                 case FD     -> chessPiecesFactory.createQueen();
                 case FE     -> chessPiecesFactory.createKing();
                 case FA, FH -> chessPiecesFactory.createRook();
                 case FB, FG -> chessPiecesFactory.createKnight();
                 case FC, FF -> chessPiecesFactory.createBishop();
             };
             chessPiece.setChessBoardRank(chessBoardRank);
             chessPiece.setChessBoardFile(chessBoardFile);
             chessPieces.add(chessPiece);
        }
    }

    private void initSet2(List<ChessPieceBase> chessPieces, ChessPiecesFactory chessPiecesFactory, ChessBoardRank chessBoardRank) {
        for (ChessBoardFile chessBoardFile   :   ChessBoardFile.values()) {
             ChessPieceBase chessPiece =
                     chessPiecesFactory.createPawn();
             chessPiece.setChessBoardRank(chessBoardRank);
             chessPiece.setChessBoardFile(chessBoardFile);
             chessPieces.add(chessPiece);
        }
    }

    //@formatter:off
    @Override
    public void update() {
          super.update() ;
          if (sprite != null) {
              float x = 0.0f;
              float y = 0.0f;
              sprite.setPosition( x , y );
          }
          for (ChessPieceBase chessPiece : chessPieces) {
              if (chessPiece != null) {
                  chessPiece.update();
              }
          }
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
          super.render(spriteBatch);
          chessPieces.sort(Comparator.comparingInt(chessPiece -> chessPiece.getChessBoardRank().number));
          Collections.reverse(chessPieces);
          for (ChessPieceBase chessPiece : chessPieces) {
              if (chessPiece != null) {
                  chessPiece.render(spriteBatch);
              }
          }
    }
    //@formatter:on
}
