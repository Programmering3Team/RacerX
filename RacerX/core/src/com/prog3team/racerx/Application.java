package com.prog3team.racerx;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.prog3team.racerx.screens.LoadingScreen;
import com.prog3team.racerx.screens.MenuScreen;

public class Application extends Game {
	public final int VIRTUAL_WIDTH = 800;
	public final int VIRTUAL_HEIGHT = 800;
	//General
	public OrthographicCamera camera;
	public Viewport viewport;
	public  SpriteBatch batch;
	public AssetManager assets;
	//Screens
	public MenuScreen menuScreen;
	public LoadingScreen loadingScreen;
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		viewport = new StretchViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);
		viewport.apply();
		camera.position.set(VIRTUAL_WIDTH/2, VIRTUAL_HEIGHT/2, 0);
		camera.update();
		assets = new AssetManager();
		//Init Screens
		loadingScreen = new LoadingScreen(this);
		menuScreen = new MenuScreen(this);
		setScreen(loadingScreen);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
		camera.update();
		super.resize(width, height);
	}
	
	@Override
	public void dispose() {
		super.dispose();
		assets.dispose();
	}
}
