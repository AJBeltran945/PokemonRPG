package main;
import java.awt.Color; // to use colors
import java.awt.Dimension; // to use dimension
import java.awt.Graphics; // to use graphics
import java.awt.Graphics2D; // to use 2D graphics
import entity.player; // to use the player class
import tile.tileManager;

import javax.swing.*;

public class gamePanel extends JPanel implements Runnable {

    // screen settings
    final int originalTileSize  = 16; // 16x16 tile
    final int scale = 4; // scale the tile by 4

    public final int tileSize = originalTileSize * scale; // 64x64 pixels
    public final int maxScreenCol = 20; // 20 tiles wide
    public final int maxScreenRow = 16; // 16 tiles tall

    public final int screenWidth = tileSize * maxScreenCol; // 1280 pixels wide
    public final int screenHeigth = tileSize * maxScreenRow; // 1024 pixels tall

    tileManager tm = new tileManager(this); // create a new tilemanager object
    KeyHandler keyH = new KeyHandler(); // create a new keyhandler object
    Thread gameThread; // thread to run the game
    player player = new player(this, keyH); // create a new player object

    public gamePanel() { // constructor

        this.setPreferredSize(new Dimension(screenWidth, screenHeigth)); // set the size of the panel
        this.setBackground(Color.BLACK); // set the background color of the panel
        this.setDoubleBuffered(true); // to prevent flickering
        this.addKeyListener(keyH); // add the keyhandler to the panel
        this.setFocusable(true); // to make the panel focusable
    }


    public void startGameThread() { // start the game thread

        gameThread = new Thread(this); // create a new thread
        gameThread.start(); // start the thread


    }

    @Override
    public void run() { // run the game

        double drawInterval = 1000000000 / 60.0; // 60 frames per second
        double delta = 0; // time passed since the last draw
        long lastTime = System.nanoTime(); // time of the last draw
        long currentTime; // current time

        while (gameThread != null){ // while the game thread is running

            currentTime = System.nanoTime(); // get the current time

            delta += (currentTime - lastTime) / drawInterval; // calculate the time passed since the last draw

            lastTime = currentTime; // set the last time to the current time

            if (delta >= 1){ // if the time passed since the last draw is greater than or equal to 1

                update();// 1 UPDATE: update info such as characters positions

                repaint(); // 2 DRAW: draw the updated info on the screen

                delta--; // reset the delta
            }
        }
    }

    public void update(){

        player.update(); // update the player
    }

    public void paintComponent ( Graphics g){

        super.paintComponent(g); // call the paintComponent method from the parent class

        Graphics2D g2 = (Graphics2D) g; // cast the graphics object to graphics2d

        tm.draw(g2); // draw the tile
        player.draw(g2); // draw the player

        g2.dispose(); // dispose the graphics object
    }
}
