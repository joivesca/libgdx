package mx.com.chilitech.zombiebird.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

import mx.com.chilitech.zombiebird.objects.Bird;

public class GameWorld {

	//private Rectangle rect = new Rectangle(0, 0, 17, 12);
	private Bird bird;
	
	public GameWorld(int midPointY){
		bird = new Bird(33, midPointY - 5, 17, 12);
	}
	
    public void update(float delta) {
        Gdx.app.log("GameWorld", "update");
        /*rect.x++;
        if (rect.x > 137) {
            rect.x = 0;
        }*/
        bird.update(delta);
    }

    /*public Rectangle getRect() {
        return rect;
    }*/
    
    public Bird getBird() {
    	return bird;
    }
}

