package com.game.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public final class MainAutoload {
    private MainAutoload() {

    }

    public static final float scale = 2.0f;
    public static final float offsetX = 16.0f;
    public static final float offsetY = 16.0f;

    public static final Texture textureChessBoard = new Texture(Gdx.files.internal("FREE - ChessSet/FREE - ChessSet/Classic/Board/Board - classic.png"));

    public static final Texture textureChessPieceBlackQueen = new Texture(Gdx.files.internal("FREE - ChessSet/FREE - ChessSet/Classic/Pieces/Chess - black classic/Queen.png"));
    public static final Texture textureChessPieceBlackKing = new Texture(Gdx.files.internal("FREE - ChessSet/FREE - ChessSet/Classic/Pieces/Chess - black classic/King.png"));
    public static final Texture textureChessPieceBlackRook = new Texture(Gdx.files.internal("FREE - ChessSet/FREE - ChessSet/Classic/Pieces/Chess - black classic/Rook.png"));
    public static final Texture textureChessPieceBlackPawn = new Texture(Gdx.files.internal("FREE - ChessSet/FREE - ChessSet/Classic/Pieces/Chess - black classic/Pawn.png"));
    public static final Texture textureChessPieceBlackBishop = new Texture(Gdx.files.internal("FREE - ChessSet/FREE - ChessSet/Classic/Pieces/Chess - black classic/Bishop.png"));
    public static final Texture textureChessPieceBlackKnight = new Texture(Gdx.files.internal("FREE - ChessSet/FREE - ChessSet/Classic/Pieces/Chess - black classic/Knight.png"));

    public static final Texture textureChessPieceWhiteQueen = new Texture(Gdx.files.internal("FREE - ChessSet/FREE - ChessSet/Classic/Pieces/Chess - white classic/Queen.png"));
    public static final Texture textureChessPieceWhiteKing = new Texture(Gdx.files.internal("FREE - ChessSet/FREE - ChessSet/Classic/Pieces/Chess - white classic/King.png"));
    public static final Texture textureChessPieceWhiteRook = new Texture(Gdx.files.internal("FREE - ChessSet/FREE - ChessSet/Classic/Pieces/Chess - white classic/Rook.png"));
    public static final Texture textureChessPieceWhitePawn = new Texture(Gdx.files.internal("FREE - ChessSet/FREE - ChessSet/Classic/Pieces/Chess - white classic/Pawn.png"));
    public static final Texture textureChessPieceWhiteBishop = new Texture(Gdx.files.internal("FREE - ChessSet/FREE - ChessSet/Classic/Pieces/Chess - white classic/Bishop.png"));
    public static final Texture textureChessPieceWhiteKnight = new Texture(Gdx.files.internal("FREE - ChessSet/FREE - ChessSet/Classic/Pieces/Chess - white classic/Knight.png"));
}
