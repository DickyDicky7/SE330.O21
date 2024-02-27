package com.game.chess;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.utils.JsonReader;
import com.game.chess.components.implementations.Position3DComponent;
import com.game.chess.components.implementations.Velocity3DComponent;

public final class AutoloadSingleton {
    private AutoloadSingleton() {

    }

    public static final ComponentMapper<Position3DComponent> position3DComponentMapper = ComponentMapper.getFor(Position3DComponent.class);
    public static final ComponentMapper<Velocity3DComponent> velocity3DComponentMapper = ComponentMapper.getFor(Velocity3DComponent.class);

    public static final Model model3DBlackQueen = new G3dModelLoader(new JsonReader()).loadModel(Gdx.files.internal("chess/black/queen.g3dj"));
    public static final Model model3DBlackPawn = new G3dModelLoader(new JsonReader()).loadModel(Gdx.files.internal("chess/black/pawn.g3dj"));
    public static final Model model3DBlackRook = new G3dModelLoader(new JsonReader()).loadModel(Gdx.files.internal("chess/black/rook.g3dj"));
    public static final Model model3DBlackKing = new G3dModelLoader(new JsonReader()).loadModel(Gdx.files.internal("chess/black/king.g3dj"));
    public static final Model model3DBlackBishop = new G3dModelLoader(new JsonReader()).loadModel(Gdx.files.internal("chess/black/bishop.g3dj"));
    public static final Model model3DBlackKnight = new G3dModelLoader(new JsonReader()).loadModel(Gdx.files.internal("chess/black/knight.g3dj"));

    public static final Model model3DWhiteQueen = new G3dModelLoader(new JsonReader()).loadModel(Gdx.files.internal("chess/white/queen.g3dj"));
    public static final Model model3DWhitePawn = new G3dModelLoader(new JsonReader()).loadModel(Gdx.files.internal("chess/white/pawn.g3dj"));
    public static final Model model3DWhiteRook = new G3dModelLoader(new JsonReader()).loadModel(Gdx.files.internal("chess/white/rook.g3dj"));
    public static final Model model3DWhiteKing = new G3dModelLoader(new JsonReader()).loadModel(Gdx.files.internal("chess/white/king.g3dj"));
    public static final Model model3DWhiteBishop = new G3dModelLoader(new JsonReader()).loadModel(Gdx.files.internal("chess/white/bishop.g3dj"));
    public static final Model model3DWhiteKnight = new G3dModelLoader(new JsonReader()).loadModel(Gdx.files.internal("chess/white/knight.g3dj"));


}
