package ca.acadianyeti.squaregirl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by patty on 07/02/16.
 */
public class Sprite
{
    Animation frames;
    private final float DELAY = 0.5f;
    private final float X_SPEED = 3f, Y_SPEED = 1f;
    private Vector3 anchor = null;
    private  int width, height, xPos, yPos;
    public Sprite(TextureRegion[] frames, int width, int height, int xPos, int yPos)
    {
        this.frames = new Animation(DELAY, frames);
        this.width = width;
        this.height = height;
        this.xPos = xPos;
        this.yPos = yPos;
    }


    /**
     * draw method, uses a sprite batch to draw this sprite on screen
     */
    public void drawSprite(SpriteBatch batch, float delta)
    {
        batch.draw(frames.getKeyFrame(delta, true), xPos, yPos, width, height);

    }


    /**
     * Set anchor
     */
    public void anchorSet(Vector3 anchor)
    {
        //Used to set the anchor for movemnt
        this.anchor = anchor;
    }

    /**
     * Update method, takes a vector2 of the new touch
     */
    public void update(Vector3 lastTouch)
    {
        //Based on anchor, move
        //Do some math yo
        if(anchor != null)
        {
            float x = lastTouch.x - anchor.x;
            if (x <= 0.0f)
            {

                xPos -= X_SPEED;
            }
            else
            {

                xPos += X_SPEED;
            }
        }
    }



    /**
     * Dispose method
     */
    public void dispose()
    {

    }


}
