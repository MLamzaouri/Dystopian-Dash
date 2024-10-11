package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import city.cs.engine.BodyImage;


public class Platform extends StaticBody {

    //image of the sand platform
    String sand = "Sprites/Rookie/3x/tilemap.png";
    public Platform(World w, float width, Vec2 position, String sand) {
        super(w, new BoxShape(width, 0.5f));
        this.setPosition(position);
        this.sand = sand;


        //Adds the image of the sand
        BodyImage image = new BodyImage(sand,1);
        addImage(image);
    }
}
