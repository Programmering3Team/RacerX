package com.prog3team.racerx.screens;

import com.badlogic.gdx.Screen;
import com.prog3team.racerx.Application;

public abstract class GameScreen implements Screen {
	protected final Application app;
	
	public GameScreen(Application app) {
		this.app = app;
	}
}
