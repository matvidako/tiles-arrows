package com.matvidako.puzzle;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.matvidako.puzzle.entity.Tile;
import com.matvidako.puzzle.entity.system.ShapeRenderingSystem;

public class GameScreen extends ScreenAdapter {

    static final int N_TILES_X = 10;
    static final int N_TILES_Y = 10;
    static final int TILE_SIZE = 30;
    static final int PADDING_SIDE = 50;
    static final int PADDING_TOP_BOTTOM = 50;

    static final int WORLD_WIDTH = N_TILES_X * TILE_SIZE + PADDING_SIDE * 2;
    static final int WORLD_HEIGHT = N_TILES_Y * TILE_SIZE + PADDING_TOP_BOTTOM * 2;


    Engine engine;
    ShapeRenderingSystem shapeRenderingSystem;
    Viewport viewport;


    @Override
    public void show() {
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
        engine = new Engine();
        engine.addSystem(new ShapeRenderingSystem(viewport));
        addSomeTiles();
    }

    private void addSomeTiles() {
        Tile tile = new Tile(new Vector2(PADDING_SIDE, PADDING_TOP_BOTTOM), TILE_SIZE, TILE_SIZE, Color.WHITE);
        engine.addEntity(tile);
        tile = new Tile(new Vector2(WORLD_WIDTH - PADDING_SIDE, WORLD_HEIGHT - PADDING_TOP_BOTTOM - TILE_SIZE), TILE_SIZE, TILE_SIZE, Color.WHITE);
        engine.addEntity(tile);
    }

    @Override
    public void render(float delta) {
        clearScreen();
        engine.update(delta);
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }


    @Override
    public void hide() {
        shapeRenderingSystem.dispose();
    }

}
