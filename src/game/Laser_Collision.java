package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class Laser_Collision implements CollisionListener {

    //If laser collides with anything it is destroyed
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (!(collisionEvent.getOtherBody() instanceof Character )) {
            collisionEvent.getReportingBody().destroy();
        }


    }
}
