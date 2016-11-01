package mx.com.chilitech.zombiebird.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import mx.com.chilitech.zombiebird.objects.Bird;
import mx.com.chilitech.zombiebird.zbhelpers.AssetLoader;

public class GameRenderer {

	 private GameWorld myWorld;
	 private OrthographicCamera cam;
	 private ShapeRenderer shapeRenderer;
     private SpriteBatch batcher;

	private int midPointY;
	private int gameHeight;
	
	 public GameRenderer(GameWorld world, int gameHeight, int midPointY) {
		 myWorld = world;

	        // The word "this" refers to this instance.
	        // We are setting the instance variables' values to be that of the
	        // parameters passed in from GameScreen.
	        this.gameHeight = gameHeight;
	        this.midPointY = midPointY;

	        cam = new OrthographicCamera();
	        cam.setToOrtho(true, 136, gameHeight);

	        batcher = new SpriteBatch();
	        batcher.setProjectionMatrix(cam.combined);
	        shapeRenderer = new ShapeRenderer();
	        shapeRenderer.setProjectionMatrix(cam.combined);
    }

    public void render(float runTime) {

    	Bird bird = myWorld.getBird();

        // Fill the entire screen with black, to prevent potential flickering.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Begin ShapeRenderer
        shapeRenderer.begin(ShapeType.Filled);

        // Draw Background color
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 136, midPointY + 66);

        // Draw Grass
        shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 66, 136, 11);

        // Draw Dirt
        shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 77, 136, 52);

        // End ShapeRenderer
        shapeRenderer.end();

        // Begin SpriteBatch
        batcher.begin();
        // Disable transparency
        // This is good for performance when drawing images that do not require
        // transparency.
        batcher.disableBlending();
        batcher.draw(AssetLoader.bg, 0, midPointY + 23, 136, 43);

        // The bird needs transparency, so we enable that again.
        batcher.enableBlending();

        // Draw bird at its coordinates. Retrieve the Animation object from
        // AssetLoader
        // Pass in the runTime variable to get the current frame.
        batcher.draw(AssetLoader.birdAnimation.getKeyFrame(runTime),
                bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());

        // End SpriteBatch
        batcher.end();

    }
    
//	public void render() {
//        Gdx.app.log("GameRenderer", "render");
//
//        /*
//         * 1. We draw a black background. This prevents flickering.
//         */
//
//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        /*
//         * 2. We draw the Filled rectangle
//         */
//
//        // Tells shapeRenderer to begin drawing filled shapes
//        shapeRenderer.begin(ShapeType.Filled);
//
//        // Chooses RGB Color of 87, 109, 120 at full opacity
//        shapeRenderer.setColor(87 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);
//
//        // Draws the rectangle from myWorld (Using ShapeType.Filled)
//        shapeRenderer.rect(myWorld.getBird().getX(), myWorld.getBird().getY(),
//                myWorld.getBird().getWidth(), myWorld.getBird().getHeight());
//
//        // Tells the shapeRenderer to finish rendering
//        // We MUST do this every time.
//        shapeRenderer.end();
//
//        /*
//         * 3. We draw the rectangle's outline
//         */
//
//        // Tells shapeRenderer to draw an outline of the following shapes
//        shapeRenderer.begin(ShapeType.Line);
//
//        // Chooses RGB Color of 255, 109, 120 at full opacity
//        shapeRenderer.setColor(255 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);
//
//        // Draws the rectangle from myWorld (Using ShapeType.Line)
//        shapeRenderer.rect(myWorld.getBird().getX(), myWorld.getBird().getY(),
//                myWorld.getBird().getWidth(), myWorld.getBird().getHeight());
//
//        shapeRenderer.end();
//    } 
}
