package com.mygdx.game.chess.engine.board;

import com.mygdx.game.chess.engine.pieces.Piece;

public abstract class Tile {

    protected final int tileCoordinate;

    private Tile(final int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }

    public static Tile createTile(final int tileCoordinate, final Piece piece) {
        if (piece != null) {
            return new OccupiedTile(tileCoordinate, piece);
        } else {
            return new NewEmptyTile(tileCoordinate);
        }
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    public final int getTileCoordinate() {
        return this.tileCoordinate;
    }

    public static final class NewEmptyTile extends Tile {
        private NewEmptyTile(final int coordinate) {
            super(coordinate);
        }

        @Override
        public String toString() {
            return "-";
        }

        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }
    }

    public static final class OccupiedTile extends Tile {
        private final Piece pieceOnTile;

        private OccupiedTile(final int tileCoordinate, final Piece pieceOnTile) {
            super(tileCoordinate);
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public String toString() {
            if (pieceOnTile.getLeague().isBlack()) {
                return pieceOnTile.toString().toLowerCase();
            } else {
                return pieceOnTile.toString();
            }
        }

        @Override
        public boolean isTileOccupied() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return this.pieceOnTile;
        }
    }
}
