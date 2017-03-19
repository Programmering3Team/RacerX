package com.prog3team.racerx.utils;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameInterface {
	public void update(float delta);
	public void render(SpriteBatch batch);
	public void dispose();
}
