package com.prog3team.racerx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.prog3team.racerx.Application;
import com.prog3team.racerx.utils.Constants;

public class PlayScreen extends GameScreen {
	//Box2D
	public World world;
	private Box2DDebugRenderer b2dr;

	public PlayScreen(Application app) {
		super(app);
	}

	@Override
	public void show() {
		world = new World(new Vector2(0,0), false);
		b2dr = new Box2DDebugRenderer();
	}
	
	private void update(float delta) {
		world.step(1/60f, 6, 2);
		app.camera.update();
		
	}

	@Override
	public void render(float delta) {
		update(delta);
		
		app.batch.setProjectionMatrix(app.camera.combined);
		Gdx.gl.glClearColor(0.2f, 0.4f, 0.6f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		app.batch.begin();
		app.batch.end();
		
		if (app.DEBUG) b2dr.render(world, app.camera.combined.scl(Constants.PPM));
		
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
		world.dispose();
		
	}

}
