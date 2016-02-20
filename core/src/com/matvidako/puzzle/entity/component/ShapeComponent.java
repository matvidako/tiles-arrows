package com.matvidako.puzzle.entity.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Color;

public class ShapeComponent implements Component {

    public float width;
    public float height;
    public Color color;
    public Type type;

    public static ShapeComponent createRectangle(float width, float height, Color color) {
        ShapeComponent rect = new ShapeComponent(Type.RECTANGLE);
        rect.width = width;
        rect.height = height;
        rect.color = color;
        return rect;
    }

    private ShapeComponent(Type type) {
        this.type = type;
    }

    public enum Type {
        RECTANGLE
    }

}
