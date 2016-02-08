package ca.acadianyeti.squaregirl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by patty on 07/02/16.
 */
public class Sprite
{
    Animation frames;
    private final float DELAY = 0.5f, MOVE_TOLERANCE = 0.1f;
    private final float X_SPEED =50f, Y_SPEED = 1f;
    protected Body body;
    private double xVel = 0.0, yVel = 0.0;
    private Vector3 anchor = null;
    private  int width, height;
    private float xPos, yPos;
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


    public void update()
    {
        //Just updates our character depending on the physics engine
        xPos = body.getPosition().x;
        yPos = body.getPosition().y;
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
            if (x < 0.0f)
            {
                body.setLinearVelocity(new Vector2(-X_SPEED, body.getLinearVelocity().y));
            }
            else if(x > 0.0f)
            {

                body.setLinearVelocity(new Vector2(X_SPEED, body.getLinearVelocity().y));
            }
        }
    }


    /**
     * Add force method, adds a force in a given direction
     */
    public void addForce(double xForce, double yForce)
    {

    }

    /**
     * Dispose method
     */
    public void dispose()
    {

    }


}
