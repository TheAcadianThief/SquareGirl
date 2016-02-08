package ca.acadianyeti.squaregirl;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SquareGirl extends Game {
	SpriteBatch batch;
	Texture img;
	BitmapFont font;
	OrthographicCamera mainCamera;
	
	@Override
	public void create () {
		mainCamera = new OrthographicCamera();
		mainCamera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		font = new BitmapFont();
		img = new Texture("SquareGirl/SQUARE_GIRL_IDLE.png");
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();


	}

	//Needed to dispose of all native elements of the game, don't forget to use
	public void dispose()
	{
		batch.dispose();
		font.dispose();
	}
}
