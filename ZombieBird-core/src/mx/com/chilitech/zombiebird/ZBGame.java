package mx.com.chilitech.zombiebird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import mx.com.chilitech.zombiebird.screens.SplashScreen;
import mx.com.chilitech.zombiebird.zbhelpers.AssetLoader;

public class ZBGame extends Game {

	@Override
	public void create() {
		Gdx.app.log("ZBGame", "created");
        AssetLoader.load();
        setScreen(new SplashScreen(this));
	}
	
	@Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
/*public class ZBGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture(Gdx.files.external("//Downloads//firma.jpg"));
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}*/
