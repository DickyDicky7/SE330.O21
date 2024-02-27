package com.game.chess.pieces.implementations.white;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.game.chess.AutoloadSingleton;
import com.game.chess.pieces.abstractions.PawnBase;

public class WhitePawn extends PawnBase {
    public WhitePawn() {
        super();
        this.model3DInstance = new ModelInstance(AutoloadSingleton.model3DWhitePawn);
    }
}
