package game;

import city.cs.engine.*;
import city.cs.engine.Shape;


import java.awt.*;

public class PointSensor extends Sensor implements SensorListener {
    private final Character character;
    private final Points point;

    //Adding sensor for points
    public PointSensor(Points point, Shape shape, Character character) {
        super(point, shape);
        this.addSensorListener(this);
        this.character = character;
        this.point = point;


    }


    //When sensor is in contact with a player, the point is collected and increments Points and gets destroyed.
    @Override
    public void beginContact(SensorEvent sensorEvent) {
        if(sensorEvent.getContactBody() instanceof Character) {
            point.destroy();
            character.pointfeed();
        }
    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}

