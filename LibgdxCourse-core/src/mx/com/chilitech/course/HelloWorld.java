package mx.com.chilitech.course;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HelloWorld extends ApplicationAdapter {
	 OrthographicCamera camera;
	 SpriteBatch batch;
	 BitmapFont font;
	 float w,h;
	 
	 @Override
	 public void create () {
	  w = Gdx.graphics.getWidth(); // width of screen
	         h = Gdx.graphics.getHeight(); // height of screen
	         camera = new OrthographicCamera(); // 2D camera
	         camera.setToOrtho(false, w, h); // y increases upwards, viewport = window
	         batch = new SpriteBatch(); // batch drawing
	         font = new BitmapFont(); // no parameters - thus default 15-pt Arial
	         font.setColor(0.0f, 0.0f, 1.0f, 1.0f); // blue font
	         font.getData().setScale(5); // font scaled up
	 }
	  
	 @Override
	 public void render () {
	    Gdx.gl.glClearColor(1, 1, 0, 1); // Clear color is yellow
	         Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear buffer with Clear color
	         batch.setProjectionMatrix(camera.combined); // Set Projection Matrix
	         batch.begin(); // begin drawing
	         font.draw(batch, "Hello World", w/2-180, h/2+50); // Draw the Hello World text
	         batch.end(); // end drawing
	 }
	 
	 @Override
	     public void dispose() {
	  batch.dispose(); // remove batch when app ending
	  font.dispose(); // remove font when app ending
	 }
	}