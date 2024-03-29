package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.InputStream;

public class Hero {
    private Texture texture;
    float x,y;
    private float speed;

    public Hero() {
        texture = new Texture("ship64.png");
        x = 640.0f;
        y = 360.0f;
        speed = 300.0f;
    }

    public void render(SpriteBatch batch){
        batch.draw(texture,x-32.0f,y-32.0f);

    }

    public void update(float dt){
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            x -= speed*dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            x += speed*dt;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            y += speed*dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            y -= speed*dt;
        }
        if (Gdx.input.isTouched()){
            if (Gdx.input.getX() > x){
                x += speed*dt;
            }
            if (Gdx.input.getX() < x){
                x -= speed*dt;
            }
            if (720.0f-Gdx.input.getY() < y){
                y -= speed*dt;
            }
            if (720.0f-Gdx.input.getY() > y){
                y += speed*dt;
            }
        }

    }

}
