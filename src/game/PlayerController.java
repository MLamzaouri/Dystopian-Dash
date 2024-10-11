package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener {
    Character character;
    boolean left = false;
    boolean right = false;
    private boolean alive;

    public void isALive(boolean alive) {
        this.alive = alive;
    }

    public PlayerController(Character character){
        this.character = character;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //First checks if the player is alive.
        if (character.isAlive()) {

            //if d is pressed then an image of him running right is shown, via left and right boolean.
            if (e.getKeyChar() == 'd') {
                right = true;
                left = false;
                character.startWalking(30);
                character.addImage(character.getrunning());

                //Jumps up
            } else if (e.getKeyChar() == 'w') {
                character.jump(50);
                if (e.getKeyChar() == 'w') {
                    character.jump(60);
                }

                //if 'a' is pressed then an image of him running left is shown, via left and right boolean.
            } else if (e.getKeyChar() == 'a') {
                right = false;
                left = true;
                character.startWalking(-30);
                character.addImage(character.getrunning_left());

                //Animation of blocking
            } else if (e.getKeyChar() == 'e') {
                if (right) {
                    character.addImage(character.getblocking());
                } else if (left) {
                    character.addImage(character.getblocking_left());
                }
                character.startWalking(0);

                //Shoots laser depending on where its facing.
            } else if (e.getKeyChar() == 'f') {

                if (right) {
                    Laser_ability laser = new Laser_ability(character, new BoxShape(1f, 0.13f));

                } else if (left) {
                    Laser_ability laser2 = new Laser_ability(character, new BoxShape(1f, 0.13f));
                    laser2.setLinearVelocity(new Vec2(-100, 0));
                    laser2.removeAllImages();
                    laser2.addImage(new BodyImage("Sprites/Rookie/3x/laser_left.png", 2f));

                }

                //dashes based on the direction its facing
            } else if (e.getKeyChar() == ' ') {

                if (right) {
                    character.addImage(character.getdash());
                    character.startWalking(100);
                } else if (left) {
                    character.addImage(character.getdash_left());
                    character.startWalking(-100);
                }
//                else if (character.getEnergy() == 0) {
//                    character.incrementEnergy();

                //Won't be able to dash if runs out of energy
                if (character.getEnergy() != 0) {
                    character.decrementEnergy();
                }

                if (character.getEnergy() == 0) {
                    if (right) {
                        character.startWalking(0);
                        character.addImage(character.getidle());
                    }

                }
                if (character.getEnergy() == 0) {
                    if (left) {
                        character.startWalking(0);
                        character.addImage(character.getidle_left());
                    }

                }

            }
        }

    }







    //Makes sure the animations are facing right directions when keys are released
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'd'){
            character.startWalking(0);
            character.addImage(character.getidle());
        }
        else if (e.getKeyChar() == 'a') {
            character.startWalking(0);
            character.addImage(character.getidle_left());

        }
        else if (e.getKeyChar() == 'e') {
            if (right) {
                character.addImage(character.getidle());
            }
            else if (left) {
                character.addImage(character.getidle_left());
            }

        }
        else if (e.getKeyChar() == 'f') {
            if (right) {
                character.addImage(character.getidle());
            }
            else if (left) {
                character.addImage(character.getidle_left());
            }
        }
        else if (e.getKeyChar() == ' ') {
            if(character.getEnergy() != 0) {
                if (right) {
                    character.addImage(character.getidle());
                } else if (left) {
                    character.addImage(character.getidle_left());
                }
                character.startWalking(0);
            }
        }
    }

}
