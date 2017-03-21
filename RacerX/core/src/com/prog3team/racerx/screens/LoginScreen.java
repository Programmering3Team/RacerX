package com.prog3team.racerx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.prog3team.racerx.Application;
import com.prog3team.racerx.utils.Constants;

public class LoginScreen extends GameScreen {
	private Stage stage;
	private BitmapFont font;
	private TextField username, password;
	
	private Texture tfTexture;
	
	public LoginScreen(Application app) {
		super(app);
	}

	@Override
	public void show() {
		stage = new Stage(app.uiViewport, app.batch);
		font = new BitmapFont();
		tfTexture = new Texture(Gdx.files.internal("1.png"));
//		initTextFields();
		Gdx.input.setInputProcessor(stage);
	}
	
	private void initTextFields() {
		TextField.TextFieldStyle tfs = new TextField.TextFieldStyle();
		tfs.font = font;
		tfs.fontColor = Color.WHITE;
		tfs.selection = new TextureRegionDrawable(new TextureRegion(tfTexture));
		tfs.background = new TextureRegionDrawable(new TextureRegion(tfTexture));
		tfs.cursor = new TextureRegionDrawable(new TextureRegion(tfTexture));
		
		username = new TextField("Enter Username", tfs);
		password = new TextField("Enter Password", tfs);
		password.setPasswordCharacter('*');
		
		username.setPosition(Constants.VIRTUAL_WIDTH/2, Constants.VIRTUAL_HEIGHT/2);
		password.setPosition(Constants.VIRTUAL_WIDTH/2, Constants.VIRTUAL_HEIGHT/2 - 50);
		
		stage.addActor(username);
		stage.addActor(password);
		
	}

	private void update(float delta) {
		stage.act();	
	}

	@Override
	public void render(float delta) {
		update(delta);
		app.batch.setProjectionMatrix(app.uiCamera.combined);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		app.batch.begin();
		app.batch.end();
		
		stage.draw();
		
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
		stage.dispose();
		tfTexture.dispose();
	}

}
