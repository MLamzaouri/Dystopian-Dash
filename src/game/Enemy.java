package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemy extends Walker implements StepListener {


    private int health = 2;
    Character character;

    //Animations for the bot moving around
    private BodyImage running_enemy = new BodyImage("Sprites/Rookie/3x/bot_idle_run.gif", 3.5f);

    private BodyImage running_enemy_left = new BodyImage("Sprites/Rookie/3x/bot_run_left.gif", 3.5f);
    Shape enemyShape = new BoxShape(1.55f,1.55f);

    private final BodyImage idle_enemy =
            new BodyImage("Sprites/Rookie/3x/bot_idle.gif", 3.5f);
    float xRight;
    float xLeft;

    public Enemy(World world, Vec2 position, float xRiight, float xLeft, Character character) {
        super(world);
        this.setPosition(position);
        this.addImage(idle_enemy);
        setGravityScale(9);
        this.xLeft = xLeft;
        this.xRight = xRiight;
        this.startWalking(40);
        world.addStepListener(this);

        //Character can walk through the bot

        Fixture fixture = new GhostlyFixture(this, enemyShape);
        Sensor sensor = new EnemySensor(this, enemyShape, character);
        this.setGravityScale(0);
        this.character = character;


    }

    //directions of the bot moving and adding animations to it
    @Override
    public void preStep(StepEvent stepEvent) {
        if (this.getPosition().x <= xLeft) {
            this.startWalking(20);
            this.removeAllImages();
            this.addImage(running_enemy);
        }
        else if (this.getPosition().x >= xRight) {
            this.startWalking(-20);
            this.removeAllImages();
            this.addImage(running_enemy_left);


        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
    public int getHealth() {
        return health;
    }

    public void decreaseHealth() {
        this.health --;
    }

}
