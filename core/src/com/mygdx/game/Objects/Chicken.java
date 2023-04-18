package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.Texture;

public class Chicken {
    private float x;
    private float y;
    private Texture texture;
    private float speed;

    public Chicken(float x, float y, Texture texture){
        this.x = x;
        this.y = y;
        this.texture = texture;
        this.speed = 15;
    }

    public Chicken(){}

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;
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

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
