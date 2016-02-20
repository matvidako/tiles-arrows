package com.matvidako.puzzle.entity;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.matvidako.puzzle.entity.component.ShapeComponent;
import com.matvidako.puzzle.entity.component.TransformComponent;

public class Tile extends Entity {

    public Tile(Vector2 pos, int width, int height, Color color) {
        add(new TransformComponent(pos));
        add(ShapeComponent.createRectangle(width, height, color));
    }

}
