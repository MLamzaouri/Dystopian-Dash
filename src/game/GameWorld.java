package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    public GameWorld(){
        super(60);

        //make the ground, with images of what the ground looks like

        Platform p1 = new Platform(this, 48, new Vec2(0, -11.5f), "Sprites/Rookie/3x/tilemap-1.png");

        Platform p2 = new Platform(this, 25, new Vec2(0, -0.8f), "Sprites/Rookie/3x/tilemap-2.png");

        Platform p3 = new Platform(this, 25, new Vec2(60f, 6f), "Sprites/Rookie/3x/tilemap-3a4.png");

        Platform p4 = new Platform(this, 25, new Vec2(-60f, 6f), "Sprites/Rookie/3x/tilemap-3a4.png");

        //Looks nicer with black outline so kept it on
        p1.setAlwaysOutline(true);
        p2.setAlwaysOutline(true);
        p3.setAlwaysOutline(true);
        p4.setAlwaysOutline(true);

//        // make two platforms
//        Shape platformShape = new BoxShape(3.5f, 0.5f);
//        StaticBody platform1 = new StaticBody(this, platformShape);
//        platform1.setPosition(new Vec2(-8, 5.5f));
//        platform1.setAngleDegrees(-45);
//
//        StaticBody platform2 = new StaticBody(this, platformShape);
//        platform2.setPosition(new Vec2(8, 5.5f));


//        //make the walls
//        Shape wallShape = new BoxShape(0.5f,8);
//        StaticBody wall1 = new StaticBody(this, wallShape);
//        wall1.setPosition(new Vec2(-11.5f,-4));

//        StaticBody wall2 = new StaticBody(this, wallShape);
//        wall2.setPosition(new Vec2(11.5f,-4));

        //Student student = new Student(this);
        //student.setPosition(new Vec2(7,-6));



//        //drop a ball on the student's head
//        Shape ballShape = new CircleShape(1f);
//        DynamicBody ball = new DynamicBody(this, ballShape);
//        ball.setPosition(new Vec2(7, 1f));



        //create a shape for the head (use PolygonEditor)
      //  PolygonShape headShape = new PolygonShape( /*coords from PolygonEditor*/);
        //create a shape for the handle (use PolygonEditor)
       // PolygonShape handleShape = new PolygonShape( /*coords from PolygonEditor*/ );
        //create the actual body and add it to the World
       // DynamicBody hammer = new DynamicBody(this); //create the hammer (no shape yet) and add it to world
        //create fixtures for head and handle and add them to
        //the hammer Body
       // SolidFixture head = new SolidFixture(hammer, headShape); //create the head fixture and add it to hammer
       // head.setDensity(20);
       // SolidFixture handle = new SolidFixture(hammer, handleShape); //create handle fixture and add it to hammer
        //attach the image
       // hammer.addImage(new BodyImage("data/hammer.png",4));
        //set the hammer's position
       // hammer.setPosition(new Vec2(0,5));


        //try this to see the effect of changing the
        //density of the hammer head
        //hammer.setAngularVelocity(10f);




    }
}
