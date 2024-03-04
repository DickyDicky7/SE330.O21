package com.game.chess;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.game.chess.components.implementations.Position2DComponent;
import com.game.chess.components.implementations.Velocity2DComponent;

public final class AutoloadSingleton {
    private AutoloadSingleton() {

    }

    public static final ComponentMapper<Position2DComponent> position2DComponentMapper = ComponentMapper.getFor(Position2DComponent.class);
    public static final ComponentMapper<Velocity2DComponent> velocity2DComponentMapper = ComponentMapper.getFor(Velocity2DComponent.class);

    public static final Texture textureChessBoard = new Texture(Gdx.files.internal("chess-board.png"));
    public static final Texture textureChessPieceBlackBishop = new Texture(Gdx.files.internal("black-bishop.png"));
    public static final Texture textureChessPieceBlackKnight = new Texture(Gdx.files.internal("black-knight.png"));
    public static final Texture textureChessPieceBlackQueen = new Texture(Gdx.files.internal("black-queen.png"));
    public static final Texture textureChessPieceBlackKing = new Texture(Gdx.files.internal("black-king.png"));
    public static final Texture textureChessPieceBlackRook = new Texture(Gdx.files.internal("black-rook.png"));
    public static final Texture textureChessPieceBlackPawn = new Texture(Gdx.files.internal("black-pawn.png"));
    public static final Texture textureChessPieceWhiteBishop = new Texture(Gdx.files.internal("white-bishop.png"));
    public static final Texture textureChessPieceWhiteKnight = new Texture(Gdx.files.internal("white-knight.png"));
    public static final Texture textureChessPieceWhiteQueen = new Texture(Gdx.files.internal("white-queen.png"));
    public static final Texture textureChessPieceWhiteKing = new Texture(Gdx.files.internal("white-king.png"));
    public static final Texture textureChessPieceWhiteRook = new Texture(Gdx.files.internal("white-rook.png"));
    public static final Texture textureChessPieceWhitePawn = new Texture(Gdx.files.internal("white-pawn.png"));

}
