package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.Texture;

public class Kanta {
    private final float x;
    private final float y;
    public final float WIDTH;
    public final float HEIGHT;
    public int type; // 0 - papir, 1 - embalaža, 2 - ostalo, 3 - steklo
    public final Texture TEXTURE;
    public Kanta(float x, float y, float width, float height, Texture texture, int type){
        this.x = x;
        this.y = y;
        this.WIDTH = width;
        this.HEIGHT = height;
        this.TEXTURE = texture;
        this.type = type;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
