package com.game.chess.pieces.abstractions;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.game.chess.AutoloadSingleton;
import com.game.chess.components.implementations.Position3DComponent;
import com.game.chess.components.implementations.Velocity3DComponent;

public abstract class ChessPieceBase extends Entity {
    public ChessPieceBase() {
        super();
        this.add(new Position3DComponent());
        this.add(new Velocity3DComponent());
    }

    protected ModelInstance model3DInstance;

    public ModelInstance getModel3DInstance() {
        return model3DInstance;
    }

    public Position3DComponent getPosition3DComponent() {
        return AutoloadSingleton.position3DComponentMapper.get(this);
    }

    public Velocity3DComponent getVelocity3DComponent() {
        return AutoloadSingleton.velocity3DComponentMapper.get(this);
    }
}
