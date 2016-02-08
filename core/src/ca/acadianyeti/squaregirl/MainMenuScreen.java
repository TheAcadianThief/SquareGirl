package ca.acadianyeti.squaregirl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by patty on 07/02/16.
 */
public class MainMenuScreen implements Screen
{
    private final int SCREEN_WIDTH = 800, SCREEN_HEIGHT = 480;
    final SquareGirl mainGame;
    //Camera typically used for 3-d stuff, we will repurpose things for 2-d
    private OrthographicCamera mainCamera;
    public MainMenuScreen(final SquareGirl mainGame)
    {
        this.mainGame = mainGame;

        mainCamera = new OrthographicCamera();
        mainCamera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
    }


    /**
     * Override the main drawing method, the render method which is where everything gets drawn
     */
    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        mainCamera.update();
        mainGame.batch.setProjectionMatrix(mainCamera.combined);

        //Start drawing this batch of sprites, becasue opengl does not enjoy
        //drawing one sprite at a time, we batch them together to be drawn together in one call
        mainGame.batch.begin();

        mainGame.font.draw(mainGame.batch, "Oy, test text", 100, 150);
        mainGame.font.draw(mainGame.batch, "Well, tap anywhere for stuff", 100, 100);

        mainGame.batch.end();

        if(Gdx.input.isTouched())
        {
            mainGame.setScreen(new GameScreen(mainGame));
            dispose();
        }

    }

    @Override
    public void dispose()
    {

    }

    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void show()
    {
        //Method called when the screen is shown
    }

    @Override
    public void hide()
    {

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

}
