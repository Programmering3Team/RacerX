package com.prog3team.racerx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.prog3team.racerx.Application;

public class MenuScreen extends GameScreen {

	public MenuScreen(Application app) {
		super(app);
	}

	@Override
	public void show() {
		
	}
	
	private void update(float delta) {
		
	}

	@Override
	public void render(float delta) {
		update(delta);
		app.batch.setProjectionMatrix(app.uiCamera.combined);
		Gdx.gl.glClearColor(1, 0, 0, 1);
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
