package com.star.app.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.star.app.game.helpers.Poolable;

public class Stuff implements Poolable {

    enum Type{
        BULLET,
        MEDICINE,
        MONEY
    }

    private GameController gc;
    private Texture texture;
    private Type type;
    private Vector2 position;
    private Circle circle;
    private boolean active;

    public Type getType() {
        return type;
    }

    public Circle getCircle() {
        return circle;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Stuff(GameController gc) {
        this.gc=gc;
        this.circle=new Circle();
        this.position=new Vector2();
        this.active=true;
        this.type=setType();
        this.texture=getTexture(type);

    }

    private Texture getTexture(Type type) {
        if (type.equals(Type.BULLET)) {
            return new Texture("images/bullet.png");
        }
        if (type.equals(Type.MEDICINE)){
            return new Texture("images/medicial.png");
        }
        else return new Texture("images/money.png");
    }

    private Type setType() {
        int typeNumber= MathUtils.random(1,3);
        if (typeNumber==1){
            return Type.BULLET;
        }
        if (typeNumber==2){
            return Type.MEDICINE;
        }
        return Type.MONEY;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture,position.x-16,position.y-16,55,32);
    }

    public void update(float dt){

    }

    @Override
    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        active = false;
    }

    public void activate(float x, float y){
        position.x=x;
        position.y=y;
        type=getType();
        active=true;
    }
}
