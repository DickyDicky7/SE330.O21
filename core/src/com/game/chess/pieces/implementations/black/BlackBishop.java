package com.game.chess.pieces.implementations.black;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.game.chess.AutoloadSingleton;
import com.game.chess.pieces.abstractions.BishopBase;

public class BlackBishop extends BishopBase {
    public BlackBishop() {
        super();
        this.model3DInstance = new ModelInstance(AutoloadSingleton.model3DBlackBishop);
    }
}
