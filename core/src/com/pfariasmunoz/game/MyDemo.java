package com.pfariasmunoz.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyDemo implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
    private float rotation;
	
	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);

		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());

		sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);

		sprite.setPosition(-sprite.getHeight() / 2, -sprite.getHeight() / 2);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();

        final float degreesPerSecond = 10.0f;
        rotation = (rotation + Gdx.graphics.getDeltaTime() * degreesPerSecond) % 360;
        sprite.setRotation(rotation);
		sprite.draw(batch);
		batch.end();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose () {
		batch.dispose();
		texture.dispose();
	}
}
