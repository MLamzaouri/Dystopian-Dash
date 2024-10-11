package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Laser_ability extends DynamicBody {


    //Laser added to the character and modified its position, appearance and velocity.
    public Laser_ability(Character c, Shape s) {
        super(c.getWorld(), s);
        this.setGravityScale(0);
        this.setPosition(new Vec2(c.getPosition().x,c.getPosition().y+0.05f));
        this.setLinearVelocity(new Vec2(100,0));
        this.addImage(new BodyImage("Sprites/Rookie/3x/laser.png", 2f));
        this.addCollisionListener(new Laser_Collision());

    }

}
