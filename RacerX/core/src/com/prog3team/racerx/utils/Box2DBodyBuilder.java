package com.prog3team.racerx.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Box2DBodyBuilder {
	
	public static Body createBoxBody(World world, Vector2 position, float width, float height, boolean fixedRotation) {
		Body body;
		BodyDef def = new BodyDef();
		def.type = BodyType.DynamicBody;
		def.position.set(position.x/Constants.PPM, position.y/Constants.PPM);
		def.fixedRotation = fixedRotation;
		body = world.createBody(def);
		
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(width/2/Constants.PPM, height/2/Constants.PPM);
		
		FixtureDef fixture = new FixtureDef();
//		fixture.filter.categoryBits = Constants.BIT_PLAYER;
//		fixture.filter.maskBits = Constants.BIT_TARGET | Constants.BIT_BULLET | Constants.BIT_LIGHT;
//		fixture.filter.groupIndex = Constants.COLLIDES_WITH_WALL;

		fixture.shape = shape;
		fixture.density = 1.0f;
		
		body.createFixture(fixture);
		
		shape.dispose();
		return body;
	}

}
