package game;

import org.jbox2d.common.Vec2;

import javax.swing.*;

/**
 * Your main game entry point
 */
public class Game {


    /** Initialise a new Game. */
    public Game() {

        //1. make your game world
        GameWorld world = new GameWorld();
        Character character = new Character(world);
        character.setPosition(new Vec2(7, -6));
        PlayerController playercontroller = new PlayerController(character);


        //Enemies in the world
        Enemy enemy1 = new Enemy(world, new Vec2(50,8), 82, 38, character);

        Enemy enemy2 = new Enemy(world, new Vec2(-50,8), -38, -82, character);

        Enemy enemy3 = new Enemy(world, new Vec2(0,1), 25, -25, character);

        //Points in the world

        Points point = new Points(world,1.5f,1f, character);

        Points point2 = new Points(world,25f,15f, character);

        Points point3 = new Points(world,-25f,15f, character);

        Points point4 = new Points(world,-60f,7.5f, character);

        Points point5 = new Points(world,60f,7.5f, character);




        //2. make a view to look into the game world
        GameView view = new GameView(world, 1280, 720, character);
        //optional: draw a 1-metre grid over the view
        //view.setGridResolution(1);


        //3. create a Java window (frame) and add the game
        //   view to it
        final JFrame frame = new JFrame("City Game");
        frame.add(view);

        Pan pan = new Pan(view, character);
        world.addStepListener(pan);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
       //  JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!
        world.start();


        frame.addKeyListener(playercontroller);

    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
