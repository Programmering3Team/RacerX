package com.prog3team.racerx.maps;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.prog3team.racerx.utils.GameInterface;

public abstract class Map implements GameInterface {
	private TiledMap tiledMap;
	private TiledMapRenderer tiledMapRenderer;
	
	public Map() {
	}
	
	//Has to be called 
	protected void initTiledMap(TiledMap tiledMap) {
		this.tiledMap = tiledMap;
		tiledMapRenderer = new OrthogonalTiledMapRenderer(this.tiledMap);
	}

	@Override
	public void update(float delta) {
		
	}

	@Override
	public void render(SpriteBatch batch) {
		
	}
	
	public void renderMap(OrthographicCamera camera) {
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
	}

	@Override
	public void dispose() {
		tiledMap.dispose();
	}

}
