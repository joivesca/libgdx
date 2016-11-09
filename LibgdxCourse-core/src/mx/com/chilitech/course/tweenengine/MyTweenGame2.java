package mx.com.chilitech.course.tweenengine;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

public class MyTweenGame2 implements ApplicationListener {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture texture;
    private Texture CircTxt, ElasticTxt, QuadTxt; //** text **//
    private Sprite sprite1, sprite2, sprite3;
    private TweenManager manager1, manager2, manager3;
    private long startTime;
    private long delta;
    private float w,h;
    private int TweenCount;
       
    @Override
    public void create() {       
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
       
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 640, 480);
        batch = new SpriteBatch();
       
        texture = new Texture("circle.png");
        texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
       
        CircTxt = new Texture("circle.png");
        CircTxt.setFilter(TextureFilter.Linear, TextureFilter.Linear);
       
        ElasticTxt = new Texture("circle.png");
        ElasticTxt.setFilter(TextureFilter.Linear, TextureFilter.Linear);
       
        QuadTxt = new Texture("circle.png");
        QuadTxt.setFilter(TextureFilter.Linear, TextureFilter.Linear);
       
        sprite1 = new Sprite(texture);
        sprite1.setPosition(50,0.25f*h);
       
        sprite2 = new Sprite(sprite1);
        sprite2.setY(0.5f*h);
       
        sprite3 = new Sprite(sprite1);
        sprite3.setY(0.75f*h);
       
        TweenCallback myCallBack = new TweenCallback(){ //** myCallBack object runs time reset **//
            @Override
            public void onEvent(int type, BaseTween<?> source) {
                startTime = TimeUtils.millis();
                TweenCount++; //** Another tween ended **//
                Gdx.app.log("my app", "ending a tween..." + TweenCount);
            }
        };
        Tween.registerAccessor(Sprite.class, new SpriteTween());
        manager1 = new TweenManager();
        Tween.to(sprite1,SpriteTween.POSITION_X,200f) //** tween POSITION_X for a duration **//
            .target(w-100) // ** final POSITION_X **//
            .ease(TweenEquations.easeInOutQuad) //** easing equation **//
            .repeatYoyo(10, 10f) //** 5 times forward, 5 times backward **//
            .setCallback(myCallBack) //** use myTweenCallback created above **//
            .setCallbackTriggers(TweenCallback.END) //** Event called 11 times after each tween **//
            .start(manager1); //** start it
        manager2 = new TweenManager();
        Tween.to(sprite2,SpriteTween.POSITION_X,200f) //** tween POSITION_X for a duration **//
            .target(w-100) // ** final POSITION_X **//
            .ease(TweenEquations.easeInOutCirc) //** easing equation **//
            .repeatYoyo(10,10f) //** 5 times forward, 5 times backward **//
            .start(manager2);
        manager3 = new TweenManager();
        Tween.to(sprite3,SpriteTween.POSITION_X,200f) // ** tween POSITION_X for a duration **/
            .target(w-100) // ** final POSITION_X **//
            .ease(TweenEquations.easeInOutElastic) //** easing equation **//
            .repeatYoyo(10,10f) //** 5 times forward, 5 times backward **//
            .start(manager3);
        startTime = TimeUtils.millis();
    }
    
    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }

    @Override
    public void render() {       
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        delta = (TimeUtils.millis()-startTime)/1000; // **get time delta **//
        manager1.update(delta); //** update sprite1 **//
        manager2.update(delta); //** update sprite2 **//
        manager3.update(delta); //** update sprite3 **//
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(ElasticTxt, 150, 0.75f*h+50);
        batch.draw(CircTxt, 150, 0.5f*h+50);
        batch.draw(QuadTxt, 150, 0.25f*h+50);
        sprite1.draw(batch);
        sprite2.draw(batch);
        sprite3.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
 