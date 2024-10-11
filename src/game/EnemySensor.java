package game;

import city.cs.engine.*;

public class EnemySensor extends Sensor implements SensorListener {
    Enemy enemy;
    Character character;

    //adding a sensor for the enemy
    public EnemySensor(Enemy body, Shape shape, Character character) {
        super(body, shape);
        this.addSensorListener(this);
        this.enemy = body;
        this.character = character;

    }


    //Enemy has 3hp, when damaged 3 times, it will be destroyed.
    @Override
    public void beginContact(SensorEvent sensorEvent) {
        if (sensorEvent.getContactBody() instanceof Character character) {
            if (character.isDamage()) {
                character.Damage();
                character.setDamage(false);
            }
        }
        if (sensorEvent.getContactBody() instanceof Laser_ability laser) {

            //laser is destroyed once in contact with a body

            laser.destroy();
            if (enemy.getHealth() == 0) {
                enemy.destroy();

                //increase the kill count when destroyed
                character.killfeed();

                //Increase energy when bot is destroyed
                if (character.getEnergy() < 20) {
                    character.incrementEnergy();

                }

                //If touches player then take hp
            } else {
                enemy.decreaseHealth();
            }

        }
    }

    //After contact the character is marked as damaged.
    @Override
    public void endContact(SensorEvent sensorEvent) {
        if (sensorEvent.getContactBody() instanceof Character character) {
            character.setDamage(true);
        }
    }
}
