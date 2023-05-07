package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;

public class Chicken {
    private float x;
    private float y;
    private Texture texture;
    private float speed;
    private Animation animation;
    public boolean moving;

    public Chicken(float x, float y, Texture texture, Animation animation){
        this.x = x;
        this.y = y;
        this.texture = texture;
        this.animation = animation;
        this.speed = 15;
        this.moving = false;
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

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }
}
