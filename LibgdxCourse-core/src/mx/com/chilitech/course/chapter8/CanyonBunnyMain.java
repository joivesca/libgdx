package mx.com.chilitech.course.chapter8;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;

import mx.com.chilitech.course.chapter8.game.Assets;
import mx.com.chilitech.course.chapter8.screens.MenuScreen;

public class CanyonBunnyMain extends Game {

	@Override
	public void create () {
		// Set Libgdx log level
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		// Load assets
		Assets.instance.init(new AssetManager());

		// Start game at menu screen
		setScreen(new MenuScreen(this));
	}
}