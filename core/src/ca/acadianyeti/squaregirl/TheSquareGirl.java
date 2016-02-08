package ca.acadianyeti.squaregirl;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by patty on 08/02/16.
 */
public class TheSquareGirl extends Sprite
{
    private static final int WIDTH = 30, HEIGHT = 30;
    public TheSquareGirl(TextureRegion[] frames, int xPos, int yPos)
    {
        super(frames, WIDTH, HEIGHT, xPos, yPos);
    }




    public void jump()
    {

    }


    @Override
    public void drawSprite(SpriteBatch batch, float delta)
    {

        super.drawSprite(batch, delta);
    }
}