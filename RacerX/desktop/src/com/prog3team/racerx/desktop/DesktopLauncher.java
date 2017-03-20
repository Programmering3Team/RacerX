package com.prog3team.racerx.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.prog3team.racerx.Application;
import com.prog3team.racerx.utils.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 800;
		config.height = 800;
		config.title = Constants.TITLE + ": version " + Constants.VERSION;
		config.resizable = false;
		new LwjglApplication(new Application(), config);
	}
}
