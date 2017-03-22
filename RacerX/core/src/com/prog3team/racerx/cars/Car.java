package com.prog3team.racerx.cars;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.prog3team.racerx.screens.PlayScreen;
import com.prog3team.racerx.utils.Box2DBodyBuilder;
import com.prog3team.racerx.utils.Constants;
import com.prog3team.racerx.utils.GameInterface;

public class Car implements GameInterface {
	private final float WIDTH = 32;
	private final float HEIGHT = 64;
	private PlayScreen playScreen;
	private CarType carType;
	private Vector2 position;
	private float rotation;
	//
	private Animation[] animations; //0 = idlde, 1 = accelerate, 2 = boost,
	private Animation currentAnimation;
	private float elapsedTime;
	//
	private Body body;
	
	public Car(CarType carType, Vector2 position, PlayScreen playScreen) {
		this.position = position;
		this.playScreen = playScreen;
		this.carType = carType;
//		animations = AnimationBuilder.getAnimations(this.carType.getPath());
//		currentAnimation = animations[0];
		body = Box2DBodyBuilder.createBoxBody(playScreen.world, position, WIDTH, HEIGHT, false);
	}

	@Override
	public void update(float delta) {
		elapsedTime += delta;
		
	}

	@Override
	public void render(SpriteBatch batch) {
//		batch.draw(currentAnimation.getKeyFrame(elapsedTime, true), position.x, position.y);
//		batch.draw(run.getKeyFrame(elapsedTime, true),zx, zy, 25/2, 26/2, 26 , 25, 1 , 1, ((float) Math.toDegrees(enemyBody.getAngle()) + 90));
	}
	
	//Setters
	public void setPosition(float x, float y) {
		this.position.x = x/Constants.PPM;
		this.position.y = y/Constants.PPM;
	}
	
	public void setRoatation(float rotation) {
		this.rotation = rotation;
	}
	
	public void setState(int state) {
//		currentAnimation = Animation[state];
	}

	@Override
	public void dispose() {
	}
	
	
	public Vector2 getPosition() { return position; }

}
