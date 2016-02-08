package ca.acadianyeti.squaregirl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

import javax.xml.bind.util.ValidationEventCollector;
import javax.xml.soap.Text;

/**
 * Created by patty on 07/02/16.
 */
public class GameScreen implements Screen
{
    //Represens how far off the anchor the currtouch can go
    private final int ANCHOR_BOUNDS = 15;



    //When we touch down, this is true, else it is false
    private boolean justTouched;
    private Vector3 currTouch, anchor;
    final SquareGirl mainGame;
    private TheSquareGirl mainChar;
    public GameScreen(final SquareGirl mainGame)
    {
        currTouch = new Vector3(0, 0, 1);
        anchor = new Vector3(0, 0, 1);
        this.mainGame = mainGame;
        //Setup our mainCharacter
        TextureRegion[] frames = new TextureRegion[1];
        frames[0] = new TextureRegion(mainGame.img);
        mainChar = new TheSquareGirl(frames, 200, 200);
    }


    @Override
    public void render(float delta)
    {

        Gdx.gl.glClearColor(0, 0.5f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //First portion is for anchoring, use justTouched
        if(Gdx.input.justTouched())
        {
            //On right side of screen, move
            if(Gdx.input.getX() >= Gdx.graphics.getWidth()/2)
            {
                justTouched = true;
                anchor.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                //Should also set currTouch to be the anchor
                currTouch.set(anchor.x, anchor.y, 0);
                mainGame.mainCamera.unproject(anchor);
                mainChar.anchorSet(anchor);
            }
            else
            {
                mainChar.jump();
            }

        }
        else if(Gdx.input.isTouched())
        {
            if(Gdx.input.getX() >= Gdx.graphics.getWidth()/2 && anchor.z != 1)
            {
                currTouch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                mainGame.mainCamera.unproject(currTouch);
                boundTouch(currTouch);
                mainChar.update(currTouch);
            }
            else
            {

            }
        }
        else
        {
            if(justTouched)
            {
                justTouched= !justTouched;
            }
            //Do this to prevent us updating anchor
            anchor.z = 1;
        }
        //Upadte main char
        //Based off anchor move the image
        //Go ahead and find out the touches, based on that move the character
        mainGame.batch.begin();
        //Draw the joystick first
        if(anchor.z != 1)
        {
            mainGame.batch.draw(mainGame.joyStick, currTouch.x - 25, currTouch.y - 25, 50, 50);
        }
        mainChar.drawSprite(mainGame.batch, delta);
        mainGame.batch.end();
    }


    /**
     * Method to bound a touch by where the anchor is
     * @param currTouch
     */
    public void boundTouch(Vector3 currTouch)
    {
        //Deal with the x
        if(currTouch.x - anchor.x > ANCHOR_BOUNDS)
        {
            currTouch.x = anchor.x + ANCHOR_BOUNDS;
        }
        else if(anchor.x - currTouch.x > ANCHOR_BOUNDS)
        {
            currTouch.x = anchor.x - ANCHOR_BOUNDS;
        }
        //Deal with the y
        if(currTouch.y - anchor.y > ANCHOR_BOUNDS)
        {
            currTouch.y = anchor.y + ANCHOR_BOUNDS;
        }
        else if(anchor.y - currTouch.y > ANCHOR_BOUNDS)
        {
            currTouch.y = anchor.y - ANCHOR_BOUNDS;
        }

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

    @Override
    public void dispose()
    {
        mainGame.dispose();
    }
}
