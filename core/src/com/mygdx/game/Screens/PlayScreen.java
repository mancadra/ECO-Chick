package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
    private Animation chickenDownWalkAnimation;
    private Animation chickenLeftWalkAnimation;
    private Animation chickenLeftDownWalkAnimation;
    private Animation chickenLeftUpWalkAnimation;
    private Animation chickenUpWalkAnimation;
    private Animation chickenRightUpWalkAnimation;
    private Animation chickenRightWalkAnimation;
    private Animation chickenRightDownWalkAnimation;
    private float chickenSpriteTime;
    public PlayScreen(ChickenGame game, SpriteBatch batch) {
        this.game = game;
        this.batch = batch;
        this.chickenSpriteTime = 0;
        TextureRegion[] chickenDownRegion = new TextureRegion[4];
        Texture tempSprite = new Texture("Chicken/sprite_chicken_down_run.png");
        TextureRegion[][] tempFrames = TextureRegion.split(tempSprite, 16, 28);
        for(int i=0; i<4; i++){
            chickenDownRegion[i] = tempFrames[i][0];
        }
        chickenDownWalkAnimation = new Animation(1f/5f, chickenDownRegion);

        TextureRegion[] chickenLeftDownRegion = new TextureRegion[4];
        tempSprite = new Texture("Chicken/sprite_chicken_left_down_run.png");
        tempFrames = TextureRegion.split(tempSprite, 16, 28);
        for(int i=0; i<4; i++){
            chickenLeftDownRegion[i] = tempFrames[i][0];
        }
        chickenLeftDownWalkAnimation = new Animation(1f/5f, chickenLeftDownRegion);

        TextureRegion[] chickenLeftRegion = new TextureRegion[4];
        tempSprite = new Texture("Chicken/sprite_chicken_left_run.png");
        tempFrames = TextureRegion.split(tempSprite, 16, 28);
        for(int i=0; i<4; i++){
            chickenLeftRegion[i] = tempFrames[i][0];
        }
        chickenLeftWalkAnimation = new Animation(1f/5f, chickenLeftRegion);

        TextureRegion[] chickenLeftUpRegion = new TextureRegion[4];
        tempSprite = new Texture("Chicken/sprite_chicken_left_up_run.png");
        tempFrames = TextureRegion.split(tempSprite, 16, 28);
        for(int i=0; i<4; i++){
            chickenLeftUpRegion[i] = tempFrames[i][0];
        }
        chickenLeftUpWalkAnimation = new Animation(1f/5f, chickenLeftUpRegion);

        TextureRegion[] chickenUpRegion = new TextureRegion[4];
        tempSprite = new Texture("Chicken/sprite_chicken_up_run.png");
        tempFrames = TextureRegion.split(tempSprite, 16, 28);
        for(int i=0; i<4; i++){
            chickenUpRegion[i] = tempFrames[i][0];
        }
        chickenUpWalkAnimation = new Animation(1f/5f, chickenUpRegion);

        TextureRegion[] chickenRightUpRegion = new TextureRegion[4];
        tempSprite = new Texture("Chicken/sprite_chicken_right_up_run.png");
        tempFrames = TextureRegion.split(tempSprite, 16, 28);
        for(int i=0; i<4; i++){
            chickenRightUpRegion[i] = tempFrames[i][0];
        }
        chickenRightUpWalkAnimation = new Animation(1f/5f, chickenRightUpRegion);

        TextureRegion[] chickenRightRegion = new TextureRegion[4];
        tempSprite = new Texture("Chicken/sprite_chicken_right_run.png");
        tempFrames = TextureRegion.split(tempSprite, 16, 28);
        for(int i=0; i<4; i++){
            chickenRightRegion[i] = tempFrames[i][0];
        }
        chickenRightWalkAnimation = new Animation(1f/5f, chickenRightRegion);

        TextureRegion[] chickenRightDownRegion = new TextureRegion[4];
        tempSprite = new Texture("Chicken/sprite_chicken_right_down_run.png");
        tempFrames = TextureRegion.split(tempSprite, 16, 28);
        for(int i=0; i<4; i++){
            chickenRightDownRegion[i] = tempFrames[i][0];
        }
        chickenRightDownWalkAnimation = new Animation(1f/5f, chickenRightDownRegion);

    }

    @Override
    public void show() {
        this.chicken = new Chicken(0, 0, new Texture("Chicken/sprite_chicken00.png"), chickenDownWalkAnimation);
        chickenTextures = new Texture[4];
        chickenTextures[0] = new Texture("Chicken/sprite_chicken00.png");
        chickenTextures[1] = new Texture("Chicken/sprite_chicken26.png");
        chickenTextures[2] = new Texture("Chicken/sprite_chicken16.png");
        chickenTextures[3] = new Texture("Chicken/sprite_chicken10.png");
        camera = new OrthographicCamera();
        viewport = new FitViewport(256, 180, camera);
    }

    public void update(float dt){
        this.chickenSpriteTime += dt;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            chicken.setTexture(chickenTextures[1]);
            chicken.setAnimation(chickenRightWalkAnimation);
            chicken.setX(chicken.getX() + chicken.getSpeed()*dt);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            chicken.setTexture(chickenTextures[3]);
            chicken.setAnimation(chickenLeftWalkAnimation);
            chicken.setX(chicken.getX() - chicken.getSpeed()*dt);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            chicken.setTexture(chickenTextures[0]);
            chicken.setAnimation(chickenDownWalkAnimation);
            chicken.setY(chicken.getY() - chicken.getSpeed()*dt);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            chicken.setTexture(chickenTextures[2]);
            chicken.setAnimation(chickenUpWalkAnimation);
            chicken.setY(chicken.getY() + chicken.getSpeed()*dt);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.A))
            chicken.setAnimation(chickenLeftUpWalkAnimation);
        else if (Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.D))
            chicken.setAnimation(chickenRightUpWalkAnimation);
        else if (Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.A))
            chicken.setAnimation(chickenLeftDownWalkAnimation);
        else if (Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.D))
            chicken.setAnimation(chickenRightDownWalkAnimation);
        chicken.moving = (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.D));
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
        if(chicken.moving)
            batch.draw((TextureRegion) chicken.getAnimation().getKeyFrame(chickenSpriteTime, true), chicken.getX(), chicken.getY());
        else
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
