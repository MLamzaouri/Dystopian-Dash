package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

//Handles collisions with character and enemy

public class CharacterCollision implements CollisionListener {
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Enemy enemy) {
            ((Character) collisionEvent.getReportingBody()).Damage();
        }
    }
}
