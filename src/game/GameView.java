package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    private final Image bg = new ImageIcon("Sprites/Rookie/3x/background.png").getImage();

    private final Character c;


    private int destroys;

    public GameView(World w, int width, int height, Character c) {
        super(w, width, height);
        this.c = c;
    }

    @Override
    protected void paintBackground(Graphics2D bg) {
        bg.drawImage(this.bg, 0, 0, this);
    }


    @Override
    protected void paintForeground(Graphics2D g) {

        //Player gets removed once his health is 0
        if (c.getHealth() == 0) {
            c.destroy();
        }

        //Heart image looped based on how many hp the player has in the top left corner
        Font font = new Font("Arial", Font.BOLD, 35);
        g.setFont(font);
        Image health = new ImageIcon("Sprites/Rookie/3x/heart.png").getImage();
        int xCor = 10;
        for (int i = 0; i <= c.getHealth()-1; i++) {
            g.drawImage(health, xCor, 15, this);
            xCor += 16;
        }

        //Energy image looped based on how many energy the player has in the top left corner
        Font font2 = new Font("Arial", Font.BOLD, 35);
        g.setFont(font2);
        Image energy = new ImageIcon("Sprites/Rookie/3x/energy.png").getImage();
        int xCor2 = 10;
        for (int i = 0; i < c.getEnergy()-1; i++) {
            g.drawImage(energy, xCor2, 40, this);
            xCor2 += 16;
        }

        //Kill count added to the top right corner
        Font font3 = new Font("Arial", Font.BOLD, 35);
        g.setFont(font3);
        g.setColor(Color.black);
        g.drawString("Kills: " + c.getKillcount(), 1100, 40);

        //Amount of points collected added to the top right corner
        Font font4 = new Font("Arial", Font.BOLD, 35);
        g.setFont(font4);
        g.setColor(Color.black);
        g.drawString("Points: " + c.getPointCollect(), 1100, 80);

        //Control for shooting in red, in the top right corner
        Font font5 = new Font("Arial", Font.BOLD, 35);
        g.setFont(font5);
        g.setColor(Color.red);
        g.drawString("Shoot = f " , 1100, 120);



    }



}



