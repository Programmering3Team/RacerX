package com.prog3team.racerx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.prog3team.racerx.Application;
import com.prog3team.racerx.screens.LoadingScreen.LoadNext;
import com.prog3team.racerx.utils.Constants;

public class LoginScreen extends GameScreen {
	private Stage stage;
	private BitmapFont font;
	private TextField textFieldUsername, textFieldPassword;
	private TextButton loginButton, signUpButton;
	
	private TextureAtlas atlas;
	private TextureRegion tfTexture, buttonTexture, buttonClickedTexture, tileTexture, pointerTexture;
	
	public LoginScreen(Application app) {
		super(app);
	}

	@Override
	public void show() {
		stage = new Stage(app.uiViewport, app.batch);
		font = new BitmapFont();
		initTextures();
		initTextFields();
		initButtons();
		Gdx.input.setInputProcessor(stage);
	}

	private void initTextures() {
		atlas = app.assets.get("img/LoginPack.atlas", TextureAtlas.class);
		
		tfTexture = atlas.findRegion("textField");
		buttonTexture = atlas.findRegion("button");
		buttonClickedTexture = atlas.findRegion("buttonPressed");
		tileTexture = atlas.findRegion("tile");
		pointerTexture = atlas.findRegion("pointer");
	}

	private void initTextFields() {
		TextField.TextFieldStyle tfs = new TextField.TextFieldStyle();
		tfs.font = font;
		tfs.fontColor = Color.BLACK;
		tfs.selection = new TextureRegionDrawable(new TextureRegion(tfTexture));
		tfs.background = new TextureRegionDrawable(new TextureRegion(tfTexture));
		tfs.cursor = new TextureRegionDrawable(new TextureRegion(pointerTexture));
		tfs.background.setLeftWidth(tfs.background.getLeftWidth() + 4);
		
		
		textFieldUsername = new TextField("", tfs);
		textFieldPassword = new TextField("", tfs);
		textFieldPassword.setPasswordMode(true);
		textFieldPassword.setPasswordCharacter('*');
		
		textFieldUsername.setPosition(Constants.VIRTUAL_UI_WIDTH/2-tfTexture.getRegionWidth()/2 - 8, Constants.VIRTUAL_UI_HEIGHT/2 + 10);
		textFieldPassword.setPosition(Constants.VIRTUAL_UI_WIDTH/2-tfTexture.getRegionWidth()/2 - 8, Constants.VIRTUAL_UI_HEIGHT/2 - 20);
		
		textFieldPassword.setTextFieldListener(new TextFieldListener() {
			@Override
			public void keyTyped(TextField textField, char c) {
				// TODO Auto-generated method stub
			}
		});

		stage.addActor(textFieldUsername);
		stage.addActor(textFieldPassword);
	}
	
	private void initButtons() {
		TextButton.TextButtonStyle tbs = new TextButton.TextButtonStyle();
		tbs.font = font;
		tbs.up = new TextureRegionDrawable(new TextureRegion(buttonTexture));
		tbs.pressedOffsetY = -1;
		tbs.down = new TextureRegionDrawable(new TextureRegion(buttonClickedTexture));
		
		loginButton = new TextButton("Log In", tbs);
		loginButton.setPosition(Constants.VIRTUAL_UI_WIDTH/2-buttonTexture.getRegionWidth()/2, Constants.VIRTUAL_UI_HEIGHT/2 - 50);
		signUpButton = new TextButton("Sign Up", tbs);
		signUpButton.setPosition(Constants.VIRTUAL_UI_WIDTH/2-buttonTexture.getRegionWidth()/2, Constants.VIRTUAL_UI_HEIGHT/2 - 80);
		
		loginButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	app.loadingScreen.load(LoadNext.PLAY);
                app.setScreen(app.loadingScreen);
            }
        });
		
		stage.addActor(loginButton);
		stage.addActor(signUpButton);
		
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
		renderTiles();
		font.setColor(Color.DARK_GRAY);
		font.draw(app.batch, Constants.TITLE + ": version " + Constants.VERSION, 7, 17);
		app.batch.end();
		
		stage.draw();
		
	}
	
	private void renderTiles() {
		for (int i = 0; i < Constants.VIRTUAL_UI_WIDTH*tileTexture.getRegionWidth() / tileTexture.getRegionWidth(); i++) {
			 for (int k = 0; k < Constants.VIRTUAL_HEIGHT*tileTexture.getRegionHeight() / tileTexture.getRegionHeight(); k++) {
				 app.batch.draw(tileTexture, i*tileTexture.getRegionWidth(), k*tileTexture.getRegionHeight());
			 }
		}
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
		font.dispose();
		atlas.dispose();
	}

}
