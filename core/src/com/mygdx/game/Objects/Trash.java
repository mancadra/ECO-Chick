package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.Texture;

public class Trash {
    private float x;
    private float y;
    public final float WIDTH;
    public final float HEIGHT;
    public final Texture TEXTURE;
    public int type; // 0 - papir, 1 - embalaža, 2 - ostalo, 3 - steklo
    public String name;
    public Trash(float x, float y, float width, float height, Texture texture, int type, String name){
        this.x = x;
        this.y = y;
        this.WIDTH = width;
        this.HEIGHT = height;
        this.TEXTURE = texture;
        this.type = type;
        this.name = name;
    }
    public Trash(float x, float y, float width, float height, Texture texture, int type){
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
