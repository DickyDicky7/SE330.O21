package com.game.chess.pieces.abstractions;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.game.chess.AutoloadSingleton;
import com.game.chess.components.implementations.Position2DComponent;
import com.game.chess.components.implementations.Velocity2DComponent;

public abstract class ChessPieceBase extends com.badlogic.ashley.core.Entity {
    public ChessPieceBase() {
        super();
        this.add(new Position2DComponent());
        this.add(new Velocity2DComponent());
    }

    protected Sprite sprite;

    public Sprite getSprite() {
        return sprite;
    }

    public Position2DComponent getPosition2DComponent() {
        return AutoloadSingleton.position2DComponentMapper.get(this);
    }

    public Velocity2DComponent getVelocity2DComponent() {
        return AutoloadSingleton.velocity2DComponentMapper.get(this);
    }
}
