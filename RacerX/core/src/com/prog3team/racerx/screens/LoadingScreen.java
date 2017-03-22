package com.prog3team.racerx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.prog3team.racerx.Application;

public class LoadingScreen extends GameScreen {
	public enum LoadNext {LOGIN, MENU, PLAY};
	private float progress;
	private LoadNext load;

	public LoadingScreen(Application app) {
		super(app);
		load = LoadNext.LOGIN;
	}
	
	public void load(LoadNext loadNext) {
		this.load = loadNext;
	}

	@Override
	public void show() {
		progress = 0;
		queueAssets();
		Gdx.input.setInputProcessor(null);
	}

	private void queueAssets() {
		app.assets.clear();
		switch (load) {
		case LOGIN:
			queueLogin();
			break;
		case MENU:
			queueMenu();
			break;
		case PLAY:
			queuePlay();
			break;
		default:
			break;
		}
	}
	
	private void queueLogin() {
		app.assets.load("img/LoginPack.atlas", TextureAtlas.class);
	}
	
	private void queueMenu() {
		
	}
	
	private void queuePlay() {
		
	}

	private void update(float delta) {
		app.assets.update();
		progress = app.assets.getProgress();
		
		if (progress >= 1) {
			switch (load) {
			case LOGIN:
				app.setScreen(app.loginScreen);
				break;
			case MENU:
				app.setScreen(app.menuScreen);
				break;
			case PLAY:
				app.setScreen(app.playScreen);
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void render(float delta) {
		update(delta);
		app.batch.setProjectionMatrix(app.uiCamera.combined);
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		app.batch.begin();
		app.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

}
