package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.Texture;

public class Trash {
    private float x;
    private float y;
    public final float WIDTH;
    public final float HEIGHT;
    public final Texture TEXTURE;
    public Trash(float x, float y, float width, float height, Texture texture){
        this.x = x;
        this.y = y;
        this.WIDTH = width;
        this.HEIGHT = height;
        this.TEXTURE = texture;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
