package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.ChickenGame;
import com.mygdx.game.Objects.Chicken;
import com.mygdx.game.Objects.Kanta;
import com.mygdx.game.Objects.Trash;

import java.util.ArrayList;

public class PlayScreen implements Screen {
    private ChickenGame game;
    private SpriteBatch batch;
    private Texture[] chickenTextures;
    private Chicken chicken;
    private OrthographicCamera camera;
    private FitViewport viewport;
    private Animation chickenDownWalkAnimation;
    private final Animation chickenLeftWalkAnimation;
    private final Animation chickenLeftDownWalkAnimation;
    private final Animation chickenLeftUpWalkAnimation;
    private final Animation chickenUpWalkAnimation;
    private final Animation chickenRightUpWalkAnimation;
    private final Animation chickenRightWalkAnimation;
    private final Animation chickenRightDownWalkAnimation;
    private float chickenSpriteTime;
    private ArrayList<Trash> trashArray;
    private Kanta[] kante;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;
    private BitmapFont font;
    private TiledMapTileLayer[] plantLayers;
    private boolean signCollision;
    private Texture signTexture;
    private boolean fullscreen;
    public PlayScreen(ChickenGame game, SpriteBatch batch) {
        this.game = game;
        this.batch = batch;
        this.chicken = new Chicken(820, 330, new Texture("Chicken/sprite_chicken00.png"), chickenDownWalkAnimation);
        this.font = new BitmapFont();
        this.chickenSpriteTime = 0;
        this.mapLoader = new TmxMapLoader();
        this.map = mapLoader.load("Tiled/map.tmx");
        this.mapRenderer = new OrthogonalTiledMapRenderer(map, batch);
        TextureRegion[] chickenDownRegion = new TextureRegion[4];
        Texture tempSprite = new Texture("Chicken/sprite_chicken_down_run.png");
        TextureRegion[][] tempFrames = TextureRegion.split(tempSprite, chicken.WIDTH, chicken.HEIGHT);
        for(int i=0; i<4; i++){
            chickenDownRegion[i] = tempFrames[i][0];
        }
        chickenDownWalkAnimation = new Animation(1f/5f, chickenDownRegion);

        TextureRegion[] chickenLeftDownRegion = new TextureRegion[4];
        tempSprite = new Texture("Chicken/sprite_chicken_left_down_run.png");
        tempFrames = TextureRegion.split(tempSprite, chicken.WIDTH, chicken.HEIGHT);
        for(int i=0; i<4; i++){
            chickenLeftDownRegion[i] = tempFrames[i][0];
        }
        chickenLeftDownWalkAnimation = new Animation(1f/5f, chickenLeftDownRegion);

        TextureRegion[] chickenLeftRegion = new TextureRegion[4];
        tempSprite = new Texture("Chicken/sprite_chicken_left_run.png");
        tempFrames = TextureRegion.split(tempSprite, chicken.WIDTH, chicken.HEIGHT);
        for(int i=0; i<4; i++){
            chickenLeftRegion[i] = tempFrames[i][0];
        }
        chickenLeftWalkAnimation = new Animation(1f/5f, chickenLeftRegion);

        TextureRegion[] chickenLeftUpRegion = new TextureRegion[4];
        tempSprite = new Texture("Chicken/sprite_chicken_left_up_run.png");
        tempFrames = TextureRegion.split(tempSprite, chicken.WIDTH, chicken.HEIGHT);
        for(int i=0; i<4; i++){
            chickenLeftUpRegion[i] = tempFrames[i][0];
        }
        chickenLeftUpWalkAnimation = new Animation(1f/5f, chickenLeftUpRegion);

        TextureRegion[] chickenUpRegion = new TextureRegion[4];
        tempSprite = new Texture("Chicken/sprite_chicken_up_run.png");
        tempFrames = TextureRegion.split(tempSprite, chicken.WIDTH, chicken.HEIGHT);
        for(int i=0; i<4; i++){
            chickenUpRegion[i] = tempFrames[i][0];
        }
        chickenUpWalkAnimation = new Animation(1f/5f, chickenUpRegion);

        TextureRegion[] chickenRightUpRegion = new TextureRegion[4];
        tempSprite = new Texture("Chicken/sprite_chicken_right_up_run.png");
        tempFrames = TextureRegion.split(tempSprite, chicken.WIDTH, chicken.HEIGHT);
        for(int i=0; i<4; i++){
            chickenRightUpRegion[i] = tempFrames[i][0];
        }
        chickenRightUpWalkAnimation = new Animation(1f/5f, chickenRightUpRegion);

        TextureRegion[] chickenRightRegion = new TextureRegion[4];
        tempSprite = new Texture("Chicken/sprite_chicken_right_run.png");
        tempFrames = TextureRegion.split(tempSprite, chicken.WIDTH, chicken.HEIGHT);
        for(int i=0; i<4; i++){
            chickenRightRegion[i] = tempFrames[i][0];
        }
        chickenRightWalkAnimation = new Animation(1f/5f, chickenRightRegion);

        TextureRegion[] chickenRightDownRegion = new TextureRegion[4];
        tempSprite = new Texture("Chicken/sprite_chicken_right_down_run.png");
        tempFrames = TextureRegion.split(tempSprite, chicken.WIDTH, chicken.HEIGHT);
        for(int i=0; i<4; i++){
            chickenRightDownRegion[i] = tempFrames[i][0];
        }
        chickenRightDownWalkAnimation = new Animation(1f/5f, chickenRightDownRegion);

        kante = new Kanta[4];
        kante[0] = new Kanta(690, 300, 31, 29, new Texture("Trash/kanta_papir.png"), 0);
        kante[1] = new Kanta(721, 300, 32, 29, new Texture("Trash/kanta_embalaza.png"), 1);
        kante[2] = new Kanta(753, 300, 31, 29, new Texture("Trash/kanta_ostali.png"), 2);
        kante[3] = new Kanta(784, 300, 33, 29, new Texture("Trash/kanta_steklo.png"), 3);

        //trashArray.add(new Trash(100, 100, 9, 14, new Texture("Trash/bottle_0.png"), 3, "Kozarec za marmelado"));
        //trashArray.add(new Trash(190, 120, 9, 14, new Texture("Trash/bottle_1.png"), 3, "Steklenica vina"));
        //trashArray.add(new Trash(140, 110, 11, 11, new Texture("Trash/paper_0.png"), 0, "Popisan list"));
        //trashArray.add(new Trash(150, 150, 14, 13, new Texture("Trash/bag_0.png"), 1, "Plastična vrečka"));
        signCollision = false;
        signTexture = new Texture("poster3-2.png");
    }

    public void addTrashToArray(MapObject obj, int type){
        MapProperties mp = obj.getProperties();
        TextureMapObject tmo = null;
        tmo = (TextureMapObject) obj;
        trashArray.add(new Trash(
                mp.get("x", float.class),
                mp.get("y", float.class),
                mp.get("width", float.class),
                mp.get("height", float.class),
                tmo.getTextureRegion(),
                type,
                obj,
                ""
        ));
    }

    @Override
    public void show() {
        chickenTextures = new Texture[4];
        chickenTextures[0] = new Texture("Chicken/sprite_chicken00.png");
        chickenTextures[1] = new Texture("Chicken/sprite_chicken26.png");
        chickenTextures[2] = new Texture("Chicken/sprite_chicken16.png");
        chickenTextures[3] = new Texture("Chicken/sprite_chicken10.png");
        camera = new OrthographicCamera();
        viewport = new FitViewport(512, 360, camera);
        trashArray = new ArrayList<>();
        String[] layerNames = {"paperTrash", "plastic Trash", "misc Trash", "glass Trash"};

        for(int i=0; i<layerNames.length; i++){
            MapObjects layerObjects = map.getLayers().get(layerNames[i]).getObjects();
            for(MapObject o : layerObjects) {
                addTrashToArray(o, i);
            }
        }
        plantLayers = new TiledMapTileLayer[11]; //0th index is empty as layer names start with 01
        for(int i=1; i<=10; i++){
            if(i==10)
                plantLayers[i] = (TiledMapTileLayer) map.getLayers().get("Rastline"+i);
            else
                plantLayers[i] = (TiledMapTileLayer) map.getLayers().get("Rastline0"+i);
        }
    }

    public void update(float dt){
        this.chickenSpriteTime += dt;
        chicken.setPrev_x(chicken.getX());
        chicken.setPrev_y(chicken.getY());
        //input
        if (Gdx.input.isKeyPressed(Input.Keys.F)){
            if (fullscreen) {
                Gdx.graphics.setWindowedMode(1280, 800); // Set your desired windowed mode dimensions
            } else {
                Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
            }
            fullscreen = !fullscreen;
        }
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
            chicken.setSpeed(50);
        else
            chicken.setSpeed(30);
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            dispose();
            game.dispose();
        }
        double minY = 9000;
        boolean isHigher = false;
        //collisions
        MapLayer layer = map.getLayers().get("Collision");
        for (MapObject o : layer.getObjects()) {
            float x = o.getProperties().get("x", float.class);
            float y = o.getProperties().get("y", float.class);
            float width = o.getProperties().get("width", float.class);
            float height = o.getProperties().get("height", float.class);
            if(recOverlap(chicken.getX()+(float)chicken.WIDTH/2, chicken.getY()-(float)chicken.HEIGHT/8, (float)chicken.WIDTH/2, (float)chicken.HEIGHT/8, x, y, width, height)) {
                chicken.setX(chicken.getPrev_x());
                chicken.setY(chicken.getPrev_y());
            }
            if(Math.sqrt(Math.pow(chicken.getX() - x, 2) + Math.pow(chicken.getY() - y, 2)) < minY) {
                minY = Math.sqrt(Math.pow(chicken.getX() - x, 2) + Math.pow(chicken.getY() - y, 2));
                isHigher = chicken.getY() > y;
            }
        }
        chicken.isHigher = isHigher;
        layer = map.getLayers().get("sign collision");
        MapObject sign = layer.getObjects().get(0);
        signCollision = false;
        float x = sign.getProperties().get("x", float.class);
        float y = sign.getProperties().get("y", float.class);
        float width = sign.getProperties().get("width", float.class);
        float height = sign.getProperties().get("height", float.class);
        if(recOverlap(chicken.getX(), chicken.getY()-(float)chicken.HEIGHT/8, chicken.WIDTH, (float)chicken.HEIGHT/8, x, y, width, height)) {
            chicken.setX(chicken.getPrev_x());
            chicken.setY(chicken.getPrev_y());
            signCollision = true;
        }
        //pick up trash
        for (int i = 0; i < trashArray.size(); i++) {
            Trash t = trashArray.get(i);
            if (recOverlap(chicken.getX(), chicken.getY(), chicken.WIDTH, chicken.HEIGHT, t.getX(), t.getY(), t.WIDTH, t.HEIGHT)) {
                if(chicken.canPickUp) {
                    chicken.currentTrash = new Trash(t.getX(), t.getY(), t.WIDTH, t.HEIGHT, t.TEXTURE_REGION, t.type, t.mapObject, t.name);
                    trashArray.remove(t);
                    chicken.canPickUp = false;
                }
            }
        }

        for (Kanta k : kante) {
            if (recOverlap(chicken.getX(), chicken.getY(), (float) chicken.WIDTH, (float) chicken.HEIGHT / 3, k.getX(), k.getY(), k.WIDTH, k.HEIGHT)) {
                chicken.setX(chicken.getPrev_x());
                chicken.setY(chicken.getPrev_y());
                if (chicken.currentTrash != null && chicken.currentTrash.type == k.type) {
                    chicken.currentTrash = null;
                    chicken.canPickUp = true;
                    chicken.trashCount++;
                } //else izgubi pointe?
            }
        }

        camera.position.x = chicken.getX() + (float)chicken.WIDTH / 2;
        camera.position.y = chicken.getY() + (float)chicken.HEIGHT / 2;
        camera.update();
        mapRenderer.setView(camera);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for (MapLayer mapLayer : map.getLayers()) {
            if (!mapLayer.getName().equals("trash") && !mapLayer.getName().contains("Rastline")) {
                // Render the map layer
                if(mapLayer instanceof TiledMapTileLayer) {
                    mapRenderer.renderTileLayer((TiledMapTileLayer) mapLayer);
                }
            }
        }
        if(!chicken.isHigher)
            mapRenderer.renderTileLayer(plantLayers[chicken.trashCount]);
        for(Kanta k : kante)
            batch.draw(k.TEXTURE, k.getX(), k.getY());
        for(Trash t : trashArray)
            batch.draw(t.TEXTURE_REGION, t.getX(), t.getY());
        if(chicken.moving)
            batch.draw((TextureRegion) chicken.getAnimation().getKeyFrame(chickenSpriteTime, true), chicken.getX(), chicken.getY());
        else
            batch.draw(chicken.getTexture(), chicken.getX(), chicken.getY());
        if(chicken.currentTrash != null){
            batch.draw(chicken.currentTrash.TEXTURE_REGION, chicken.getX()+chicken.WIDTH/chicken.currentTrash.WIDTH, chicken.getY()+chicken.HEIGHT + chicken.HEIGHT/chicken.currentTrash.HEIGHT - 5);
        }
        if(chicken.isHigher)
            mapRenderer.renderTileLayer(plantLayers[chicken.trashCount]);
        //if(chicken.currentTrash != null)
        //    font.draw(batch, chicken.currentTrash.name, chicken.getX()-100, chicken.getY()-50);
        batch.end();
        if(signCollision) {
            batch.setProjectionMatrix(batch.getProjectionMatrix().setToOrtho2D(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
            batch.begin();
            batch.draw(signTexture, (float)(Gdx.graphics.getWidth() - 1280)/2, (float)(Gdx.graphics.getHeight() - 800)/2);
            batch.end();
        }
        update(delta);
    }

    public static boolean recOverlap(float x1, float y1, float w1, float h1, float x2, float y2, float w2, float h2) {
        return (x1 < x2 + w2 && x1 + w1 > x2 && y1 < y2 + h2 && y1 + h1 > y2);
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
