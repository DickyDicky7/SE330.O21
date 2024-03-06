package com.game.chess;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.chess.components.implementations.Position2DComponent;
import com.game.chess.components.implementations.Velocity2DComponent;

public abstract class Entity2DBase {
    protected Sprite sprite;
    protected final Position2DComponent position2DComponent;
    protected final Velocity2DComponent velocity2DComponent;

    public Entity2DBase() {
        super();
        this.position2DComponent = new Position2DComponent();
        this.velocity2DComponent = new Velocity2DComponent();
    }

    public Sprite getSprite() {
        return sprite;
    }

    public Position2DComponent getPosition2DComponent() {
        return position2DComponent;
    }

    public Velocity2DComponent getVelocity2DComponent() {
        return velocity2DComponent;
    }

    public void handle() {

    }

    public void update() {

    }

    //@formatter:off
    public void render (SpriteBatch spriteBatch) {
        if (sprite != null) {
            float x = sprite.getX() * MainAutoload.SCALE;
            float y = sprite.getY() * MainAutoload.SCALE;
            float w = sprite.getWidth () * MainAutoload.SCALE;
            float h = sprite.getHeight() * MainAutoload.SCALE;
            spriteBatch.draw(
                    sprite,
                    x,
                    y,
                    w,
                    h);
        }
    }
}
