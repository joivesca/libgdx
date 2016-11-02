package mx.com.chilitech.zombiebird.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import mx.com.chilitech.zombiebird.ZBGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Zombie Bird";
        config.width = 272;
        config.height = 408;
		new LwjglApplication(new ZBGame(), config);
	}
	
	//http://www.kilobolt.com/day-7-the-grass-the-bird-and-the-skull-pipe.html
}
