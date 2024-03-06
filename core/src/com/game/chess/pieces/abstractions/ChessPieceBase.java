package com.game.chess.pieces.abstractions;

import com.game.chess.MainAutoload;
import com.game.chess.boards.implementations.ChessBoardFile;
import com.game.chess.boards.implementations.ChessBoardRank;

//@formatter:off
public abstract class ChessPieceBase extends com.game.chess.Entity2DBase {
    public ChessPieceBase() {
        super();
        chessBoardFile = ChessBoardFile.FA;
        chessBoardRank = ChessBoardRank.R1;
    }

    private ChessBoardFile chessBoardFile;
    private ChessBoardRank chessBoardRank;

    public void setChessBoardFile(ChessBoardFile chessBoardFile) {
        this.chessBoardFile = chessBoardFile;
    }

    public void setChessBoardRank(ChessBoardRank chessBoardRank) {
        this.chessBoardRank = chessBoardRank;
    }

    public ChessBoardFile getChessBoardFile() {
        return chessBoardFile;
    }

    public ChessBoardRank getChessBoardRank() {
        return chessBoardRank;
    }

    @Override
    public void update() {
          super.update();
        if (sprite != null) {
            float x = chessBoardFile.number * MainAutoload.CHESS_BOARD_CELL_W + MainAutoload.CHESS_BOARD_PADDING_X;
            float y = chessBoardRank.number * MainAutoload.CHESS_BOARD_CELL_H + MainAutoload.CHESS_BOARD_PADDING_Y;
            sprite.setPosition( x , y );
        }
    }
}
