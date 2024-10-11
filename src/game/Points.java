package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import city.cs.engine.Sensor;

public class Points extends DynamicBody implements StepListener {

    //Shape and image of points
    private static final Shape PointShape = new BoxShape(2f, 2f);
    private static final BodyImage PointImage = new BodyImage("Sprites/Rookie/3x/point.png", 2);
    private float max;
    private float min;



    //Makes the appearance of a point, position and its behaviour to the character.
    public Points(GameWorld world, float x, float y, Character character) {
        super(world);
        this.setGravityScale(0);
        this.addImage(PointImage);
        Fixture fixture = new GhostlyFixture(this, PointShape);
        Sensor sensor = new PointSensor(this, PointShape,character);
        world.addStepListener(this);
        this.setPosition(new Vec2(x, y));
        this.setProximity();
    }

    //When coin is within the characters proximity, it's collected.
    private void setProximity() {
        this.max = this.getPosition().y+0.4f;
        this.min = this.getPosition().y+0.4f;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        }


    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
