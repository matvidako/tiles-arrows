package com.matvidako.puzzle.entity.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class TransformComponent implements Component {

    public final Vector3 pos = new Vector3();
    public final Vector2 scale = new Vector2(1.0f, 1.0f);
    public float rotation = 0.0f;

    public TransformComponent(Vector2 pos) {
        this.pos.x = pos.x;
        this.pos.y = pos.y;
    }

    public float z() {
        return pos.z;
    }

    public float x() {
        return pos.x;
    }

    public float y() {
        return pos.y;
    }

}
