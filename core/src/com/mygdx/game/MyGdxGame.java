package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Hero hero;
	Background background;
	Asteroid asteroid;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		hero = new Hero();
		asteroid = new Asteroid();

	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		update(dt);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
		hero.render(batch);
		asteroid.render(batch);
		batch.end();
	}

	private void update(float dt) {
	    background.update(dt);
		hero.update(dt);
		asteroid.update(dt);
		if (asteroid.collisionX-hero.collisionX<5 /*
		Тут проблема небольшая. Если я буду двигать корабль навстречу, то не всегда будет срабатывать if
		Решим проблему увеличение цифры 5, но тогда будет казаться, что корабль еще не столкнулся
		с астероидом. Сравнивать значения collisionX тоже нельзя по той же причине.
		*/&& asteroid.collisionX-hero.collisionX >0
                && (Math.abs(hero.y-asteroid.y))<=64) {
		    asteroid.reset();

        }

	}

	@Override
	public void dispose () {
		batch.dispose();

	}
}
