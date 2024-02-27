package com.game.chess.pieces.implementations.white;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.game.chess.AutoloadSingleton;
import com.game.chess.pieces.abstractions.KingBase;

public class WhiteKing extends KingBase {
    public WhiteKing() {
        super();
        this.model3DInstance = new ModelInstance(AutoloadSingleton.model3DWhiteKing);
    }
}
