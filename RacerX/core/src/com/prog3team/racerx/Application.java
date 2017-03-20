package com.prog3team.racerx;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.prog3team.racerx.screens.LoadingScreen;
import com.prog3team.racerx.screens.MenuScreen;
import com.prog3team.racerx.utils.Constants;

public class Application extends Game {
	//General
	public OrthographicCamera camera, uiCamera;
	public Viewport viewport, uiViewport;
	public  SpriteBatch batch;
	public AssetManager assets;
	//Screens
	public MenuScreen menuScreen;
	public LoadingScreen loadingScreen;
	
	@Override
	public void create () {
		//General
		initCameras();
		batch = new SpriteBatch();
		assets = new AssetManager();
		//Init Screens
		loadingScreen = new LoadingScreen(this);
		menuScreen = new MenuScreen(this);
		setScreen(loadingScreen);
	}

	private void initCameras() {
		//Standard Camera
		camera = new OrthographicCamera();
		viewport = new StretchViewport(Constants.VIRTUAL_WIDTH, Constants.VIRTUAL_HEIGHT, camera);
		viewport.apply();
		camera.position.set(Constants.VIRTUAL_WIDTH/2, Constants.VIRTUAL_HEIGHT/2, 0);
		camera.update();
		//UI Camera
		uiCamera = new OrthographicCamera();
		uiViewport = new StretchViewport(Constants.VIRTUAL_WIDTH, Constants.VIRTUAL_HEIGHT, uiCamera);
		uiViewport.apply();
		uiCamera.position.set(Constants.VIRTUAL_WIDTH/2, Constants.VIRTUAL_HEIGHT/2, 0);
		uiCamera.update();
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
