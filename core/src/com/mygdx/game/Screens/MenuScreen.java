package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.ChickenGame;

public class MenuScreen implements Screen {

    ChickenGame game;
    SpriteBatch batch;
    private OrthographicCamera camera;
    private FitViewport viewport;
    private Texture startTexture;

    public MenuScreen(ChickenGame game, SpriteBatch batch){
        this.game = game;
        this.batch = batch;
        camera = new OrthographicCamera();
        viewport = new FitViewport(1280, 800, camera);
        startTexture = new Texture("start.png");
    }

    @Override
    public void show() {

    }

    public void update(float dt){
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            dispose();
            game.dispose();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY) || Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            dispose();
            game.setScreen(new PlayScreen(game, batch));
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(startTexture, 0, 0, 1280, 800);
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
        startTexture.dispose();
    }
}
