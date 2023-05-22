package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;

public class Trash {
    private float x;
    private float y;
    public final float WIDTH;
    public final float HEIGHT;
    public final TextureRegion TEXTURE_REGION;
    public int type; // 0 - papir, 1 - embalaža, 2 - ostalo, 3 - steklo
    public String name;
    public MapObject mapObject; //<- Da lahko referencamo corresponding MapObject na tilemapu
    public Trash(float x, float y, float width, float height, TextureRegion tr, int type, MapObject mapObject, String name) {
        this.x = x;
        this.y = y;
        this.WIDTH = width;
        this.HEIGHT = height;
        this.TEXTURE_REGION = tr;
        this.type = type;
        this.name = name;
        this.mapObject = mapObject;
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
