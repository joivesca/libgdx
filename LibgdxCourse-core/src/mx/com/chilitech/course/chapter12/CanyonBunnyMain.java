package mx.com.chilitech.course.chapter12;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.math.Interpolation;

import mx.com.chilitech.course.chapter12.util.AudioManager;
import mx.com.chilitech.course.chapter12.util.GamePreferences;
import mx.com.chilitech.course.chapter12.game.Assets;
import mx.com.chilitech.course.chapter12.screens.DirectedGame;
import mx.com.chilitech.course.chapter12.screens.MenuScreen;
import mx.com.chilitech.course.chapter12.screens.transitions.ScreenTransition;
import mx.com.chilitech.course.chapter12.screens.transitions.ScreenTransitionSlice;

public class CanyonBunnyMain extends DirectedGame {

	@Override
	public void create() {
		// Set Libgdx log level
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		// Load assets
		Assets.instance.init(new AssetManager());

		// Load preferences for audio settings and start playing music
		GamePreferences.instance.load();
		AudioManager.instance.play(Assets.instance.music.song01);

		// Start game at menu screen
		ScreenTransition transition = ScreenTransitionSlice.init(2, ScreenTransitionSlice.UP_DOWN, 10,
				Interpolation.pow5Out);
		setScreen(new MenuScreen(this), transition);
	}

}