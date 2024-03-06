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
            sprite.setScale (MainAutoload.scale);
            sprite.setOrigin(
                    - sprite.getWidth () / 2.0f - 1.5f,
                    - sprite.getHeight() / 2.0f + 4.0f);
            float x = chessBoardFile.number * sprite.getWidth() * sprite.getScaleX();
            float y = chessBoardRank.number * sprite.getWidth() * sprite.getScaleY();
            sprite.setPosition( x , y );
        }
    }
}
