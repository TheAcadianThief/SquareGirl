package ca.acadianyeti.squaregirl;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by patty on 08/02/16.
 */
public class TheSquareGirl extends Sprite
{
    private boolean jumping;
    private static final int WIDTH = 40, HEIGHT = 40;
    private static final float PIXELS_TO_METERS= 100.0f;
    public TheSquareGirl(TextureRegion[] frames, int xPos, int yPos, World gameWorld)
    {
        super(frames, WIDTH, HEIGHT, xPos, yPos);
        //Use the gameworld to set up our character
        BodyDef def = new BodyDef();

        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set((xPos + WIDTH ), (yPos + HEIGHT));
        body = gameWorld.createBody(def);

        //Make our shape
        PolygonShape shape = new PolygonShape();
        //Set it to a box shape
        shape.setAsBox(WIDTH/2 /  PIXELS_TO_METERS, HEIGHT/2 / PIXELS_TO_METERS);

        //Define properties like density, volume blahblah blah
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;

        Fixture fixture = body.createFixture(fixtureDef);

        //Dispose of the shape
        shape.dispose();
    }


    /**
     * Jump method, commences jump
     */
    public void jump()
    {
        jumping =true;
        //Need to have some kind of add force method

        System.out.println("Jumping currently");
    }


    @Override
    public void drawSprite(SpriteBatch batch, float delta)
    {

        super.drawSprite(batch, delta);
    }
}