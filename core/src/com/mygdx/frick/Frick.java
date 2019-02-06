package com.mygdx.frick;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Frick extends ApplicationAdapter implements InputProcessor {
    //Texture img;
    TiledMap board;
    OrthographicCamera camera;
    TiledMapRenderer boardRenderer;


    @Override
    public void create() {
        //float w= Gdx.graphics.getWidth();
        //float h= Gdx.graphics.getHeight();
        float w = 256;
        float h = 256;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);
        camera.update();
        board = new TmxMapLoader().load("map.tmx");
        boardRenderer = new OrthogonalTiledMapRenderer(board);
        Gdx.input.setInputProcessor(this);


    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        boardRenderer.setView(camera);
        boardRenderer.render();


    }

    @Override
    public void dispose() {
        //	img.dispose();
    }

    @Override
    public boolean keyDown(int key) {
        return false;
    }

    @Override
    public boolean keyUp(int key) {
        if (key== Input.Keys.LEFT)
            camera.translate(-32, 0);
        if (key== Input.Keys.RIGHT)
            camera.translate(32, 0);
        if (key== Input.Keys.UP)
            camera.translate(0, -32);
        if (key== Input.Keys.DOWN)
            camera.translate(0, 32);
        if (key== Input.Keys.NUM_1)
            board.getLayers().get(0).setVisible(!board.getLayers().get(0).isVisible());
        if (key== Input.Keys.NUM_2)
            board.getLayers().get(1).setVisible(!board.getLayers().get(1).isVisible());
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }
}
