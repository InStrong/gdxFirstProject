package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Asteroid {
    private Texture texture;
    float x,y;
    private float speed;
    float bottomCollisionPoint;
    float topCollisionPoint;
    float collisionX;
    public Asteroid(){
        this.x = 1280+32;
        this.y = MathUtils.random(32,720-32);
        this.speed = MathUtils.random(300.0f,600.0f);
        this.texture = new Texture("asteroids64.png");
    }

    public void render(SpriteBatch batch){
        batch.draw(texture,x,y,128,64,64,64,1.0f,1.0f,0,128,0,64,64,false,false);

    }
    public void update(float dt){
        bottomCollisionPoint = y-32.0f;
        topCollisionPoint = y+32.0f;
        collisionX = x-32.0f;
        x -=speed*dt;
        if (x<-32){
            this.x = 1280;
            this.y = MathUtils.random(32,720-32);
            this.speed = MathUtils.random(300.0f,600.0f);
        }
    }

    public void reset(){
        x=1280+32;
        this.y = MathUtils.random(32,720-32);
    }
}
