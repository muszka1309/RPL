package com.brentaureli.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.brentaureli.game.states.GameStateManager;
import com.brentaureli.game.states.MenuState;

public class QuizGame extends ApplicationAdapter {
    public static final int WIDTH = 1080;
    public static final int HEIGHT = 1920;

    public DatabaseInterface database;

    public static final String TITLE = "Rescue Programming Languages";
    private GameStateManager gsm;
    private SpriteBatch batch;

    private static QuizGame instance = null;

    public static QuizGame getInstance() {
        return instance;
    }

    public QuizGame(DatabaseInterface database) {
        instance = this;
        this.database = database;
    }

	@Override
	public void create () {
		batch = new SpriteBatch();
        gsm = new GameStateManager();
        Gdx.gl.glClearColor(0, 0, 1, 1);
        gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
	}

    @Override
    public void dispose() {
        super.dispose();
    }

}
