package mx.com.chilitech.course.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;


import mx.com.chilitech.course.chapter12.CanyonBunnyMain;
import mx.com.chilitech.course.chapter13.MyModelTest;
import mx.com.chilitech.course.chapter14.MyCollisionTest;


public class DesktopLauncher {
	
	private static boolean rebuildAtlas = false;
	private static boolean drawDebugOutline = false;
	
	public static void main (String[] arg) {
		//LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//new LwjglApplication(new LibgdxCourse(), config);
		/* Ligths
		config.title = "box2d lights test";
		config.width = 800;
		config.height = 480;
		config.samples = 4;
		config.depth = 0;
		config.vSyncEnabled = true;

		config.fullscreen = false;
		
		new LwjglApplication(new Box2dLightCustomShaderTest(), config);
		
		*/
		
		/* chapter2
		 * 
		 *
		config.title = "demo";
		config.width = 480;
		config.height = 320;
		new LwjglApplication(new MyDemo(), config);
		
		*/
		
		/* Chapter 3
		 * 
		 *
		config.title = "CanyonBunny";
		config.width = 480;
		config.height = 320;
		
		new LwjglApplication(new CanyonBunnyMain(), config);
		*/
		
		/* Chapter 4
		 * 
		 */
		/*if (rebuildAtlas) {
			Settings settings = new Settings();
			settings.maxWidth = 1024;
			settings.maxHeight = 1024;
			settings.duplicatePadding = false;
			settings.debug = drawDebugOutline;
			TexturePacker.process(settings, "assets-raw/images", "../CanyonBunny-android/assets/images", "canyonbunny.pack");
		}

		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "CanyonBunny";
		cfg.width = 800;
		cfg.height = 480;

		new LwjglApplication(new CanyonBunnyMain(), cfg);
		*/
		
		/* Chapter 5, 6, 7, 8
		 * 
		 *
		
			if (rebuildAtlas) {
				Settings settings = new Settings();
				settings.maxWidth = 1024;
				settings.maxHeight = 1024;
				settings.debug = drawDebugOutline;
				TexturePacker.process(settings, "assets-raw/images", "../CanyonBunny-android/assets/images", "canyonbunny.pack");
			}
			
			LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
			cfg.title = "CanyonBunny";
			cfg.width = 800;
			cfg.height = 480;
			
			new LwjglApplication(new CanyonBunnyMain(), cfg);
		*/
		/* Chapter 9,10,11,12
		 * 
		 *
		if (rebuildAtlas) {
			Settings settings = new Settings();
			settings.maxWidth = 1024;
			settings.maxHeight = 1024;
			settings.debug = drawDebugOutline;
			TexturePacker.process(settings, "assets-raw/images", "../CanyonBunny-android/assets/images", "canyonbunny.pack");
			TexturePacker.process(settings, "assets-raw/images-ui", "../CanyonBunny-android/assets/images", "canyonbunny-ui.pack");
		}

		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "CanyonBunny";
		cfg.width = 800;
		cfg.height = 480;

		new LwjglApplication(new CanyonBunnyMain(), cfg);
		*/
		
		/* Chapter 13
		 * 
		 *
		
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "ModelTest";
		cfg.width = 800;
		cfg.height = 480;
		
		new LwjglApplication(new MyModelTest(), cfg);
		*/
		
		/*Chapter 14
		 * 
		 */
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new MyCollisionTest(), config);
		
	}
}
