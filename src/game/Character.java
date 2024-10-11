package game;

import city.cs.engine.*;

public class Character extends Walker {
    private static Shape CharacterShape = new BoxShape(1.2f,1.45f);

    private boolean damage = true;


    //Animations for different player actions
    private final BodyImage idle =
            new BodyImage("Sprites/Rookie/3x/vagabond-idle.gif", 3.5f);

    private final BodyImage running =
            new BodyImage("Sprites/Rookie/3x/vagabond-run.gif", 3.5f);

    private final BodyImage blocking =
            new BodyImage("Sprites/Rookie/3x/vagabond-block.gif", 3.5f);

    private final BodyImage dash =
            new BodyImage("Sprites/Rookie/3x/vagabond-dash.gif",3f);

    private final BodyImage idle_left =
            new BodyImage("Sprites/Rookie/3x/vagabond-idle-left.gif", 3.5f);

    private final BodyImage running_left =
            new BodyImage("Sprites/Rookie/3x/vagabond-run-left.gif", 3.5f);

    private final BodyImage blocking_left =
            new BodyImage("Sprites/Rookie/3x/vagabond-block-left.gif", 3.5f);

    private final BodyImage death =
            new BodyImage("Sprites/Rookie/3x/vagabond-death.gif", 3.5f);


    private final BodyImage dash_left =
            new BodyImage("Sprites/Rookie/3x/vagabond-dash-left.gif",3f);


    //Important variables for stats purposes
    private int credits = 0;
    private int health = 10;
    private int energy = 20;

    private int killcount = 0;

    private int pointCollect = 0;

    private boolean alive;


    //Checks if player is below 1 otherwise player dies.
    public void Damage() {
        health = health -1;
        isAlive();
    }

    public boolean isAlive() {
        alive = health+1 > 0;
        return alive;
    }


    public Character(World world) {
        super(world, CharacterShape);
        this.addImage(idle);
        credits = 0;
        this.setGravityScale(8);
        this.addCollisionListener(new CharacterCollision());
        //setAlwaysOutline(true);
        SolidFixture fixture = new SolidFixture(this, CharacterShape);
        fixture.setFriction(0);
    }

    //Getter methods below.

    public void setCredits(int credits){
        this.credits = credits;
    }
    public int getCredits(){
        return credits;
    }

    public BodyImage getidle() {
        this.removeAllImages();
        return idle;
    }

    public BodyImage getrunning() {
        this.removeAllImages();
        return running;
    }

    public BodyImage getblocking() {
        this.removeAllImages();
        return blocking;
    }

    public BodyImage getdash() {
        this.removeAllImages();
        return dash;
    }

    public BodyImage getidle_left() {
        this.removeAllImages();
        return idle_left;
    }

    public BodyImage getrunning_left() {
        this.removeAllImages();
        return running_left;
    }

    public BodyImage getblocking_left() {
        this.removeAllImages();
        return blocking_left;
    }
    public BodyImage getDeath() {
        this.removeAllImages();
        return death;
    }


    public BodyImage getdash_left() {
        this.removeAllImages();
        return dash_left;
    }
    public int getHealth(){
        return health;
    }

    public int getKillcount(){
        return killcount;
    }

    public int getPointCollect(){
        return pointCollect;
    }


    public int getEnergy(){
        return energy;
    }

    //Increases or decreases energy for the player

    public void decrementEnergy(){
        this.energy --;
    }
    public void incrementEnergy(){
        int remainingEnergy = 20 - getEnergy();
        if (remainingEnergy > 0) {
            energy += remainingEnergy;
        }


    }

    //Increments kills and points
    public void killfeed() {
        killcount++;
    }

    public void pointfeed() {
        pointCollect++;
    }


    public boolean isDamage() {
        return damage;
    }

    public void setDamage(boolean damage) {
        this.damage = damage;
    }


}
