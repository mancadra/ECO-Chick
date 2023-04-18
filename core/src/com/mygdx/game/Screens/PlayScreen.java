package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.ChickenGame;
import com.mygdx.game.Objects.Chicken;

public class PlayScreen implements Screen {
    private ChickenGame game;
    private SpriteBatch batch;
    private Texture[] chickenTextures;
    private Chicken chicken;
    private OrthographicCamera camera;
    private FitViewport viewport;
    public PlayScreen(ChickenGame game, SpriteBatch batch) {
        this.game = game;
        this.batch = batch;
    }

    @Override
    public void show() {
        this.chicken = new Chicken(0, 0, new Texture("Player/chicken_front.png"));
        chickenTextures = new Texture[4];
        chickenTextures[0] = new Texture("Player/chicken_front.png");
        chickenTextures[1] = new Texture("Player/chicken_right.png");
        chickenTextures[2] = new Texture("Player/chicken_back.png");
        chickenTextures[3] = new Texture("Player/chicken_left.png");
        camera = new OrthographicCamera();
        viewport = new FitViewport(256, 180, camera);
    }

    public void update(float dt){
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            chicken.setTexture(chickenTextures[1]);
            chicken.setX(chicken.getX() + chicken.getSpeed()*dt);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            chicken.setTexture(chickenTextures[3]);
            chicken.setX(chicken.getX() - chicken.getSpeed()*dt);
    }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            chicken.setTexture(chickenTextures[0]);
            chicken.setY(chicken.getY() - chicken.getSpeed()*dt);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            chicken.setTexture(chickenTextures[2]);
            chicken.setY(chicken.getY() + chicken.getSpeed()*dt);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
            chicken.setSpeed(25);
        else
            chicken.setSpeed(15);
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
            game.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(chicken.getTexture(), chicken.getX(), chicken.getY());
        batch.end();
        update(delta);
    }

    @Override
    public void resize(int width, int height) {
        batch.setProjectionMatrix(camera.combined);
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        for(Texture t:chickenTextures)
            t.dispose();
    }
}
