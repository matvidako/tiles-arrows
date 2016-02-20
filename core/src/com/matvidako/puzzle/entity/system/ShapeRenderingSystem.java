package com.matvidako.puzzle.entity.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.matvidako.puzzle.entity.component.ShapeComponent;
import com.matvidako.puzzle.entity.component.TransformComponent;


public class ShapeRenderingSystem extends IteratingSystem implements Disposable {

    private ComponentMapper<ShapeComponent> shapeMapper;
    private ComponentMapper<TransformComponent> transformMapper;
    private final ShapeRenderer shapeRenderer;
    private final Viewport viewport;

    public ShapeRenderingSystem(Viewport viewport) {
        super(Family.all(ShapeComponent.class, TransformComponent.class).get());
        this.shapeRenderer = new ShapeRenderer();
        this.viewport = viewport;
        shapeMapper = ComponentMapper.getFor(ShapeComponent.class);
        transformMapper = ComponentMapper.getFor(TransformComponent.class);
    }

    @Override
    public void update(float deltaTime) {
        viewport.apply();
        shapeRenderer.setProjectionMatrix(viewport.getCamera().combined);
        shapeRenderer.setAutoShapeType(true);
        shapeRenderer.begin();
        super.update(deltaTime);
        shapeRenderer.end();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        ShapeComponent shape = shapeMapper.get(entity);
        TransformComponent transform = transformMapper.get(entity);
        switch (shape.type) {
            case RECTANGLE:
                renderRectangle(shape, transform);
                break;
        }
    }

    private void renderRectangle(ShapeComponent shape, TransformComponent transform) {
        shapeRenderer.setColor(shape.color);
        shapeRenderer.rect(transform.x(), transform.y(), shape.width, shape.height);
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }

}
