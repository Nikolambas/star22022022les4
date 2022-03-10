package com.star.app.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.star.app.game.helpers.ObjectPool;

public class StuffController extends ObjectPool<Stuff> {
    private GameController gc;

    public StuffController() {
        this.gc = gc;
    }


    @Override
    protected Stuff newObject() {
        return new Stuff(gc);
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < activeList.size(); i++) {
            Stuff a = activeList.get(i);
            a.render(batch);
        }
    }

    public void update(float dt) {
        for (int i = 0; i < activeList.size(); i++) {
            activeList.get(i).update(dt);
        }
        checkPool();
    }

    public void setup(float x,float y){
        getActiveElement().activate(x,y);
    }
}
