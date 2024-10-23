package main;
import java.awt.Color; // to use colors
import java.awt.Dimension; // to use dimension
import java.awt.Graphics; // to use graphics
import java.awt.Graphics2D; // to use 2D graphics

import javax.swing.*;

public class gamePanel extends JPanel implements Runnable {

    // screen settings
    final int originalTileSize  = 16; // 16x16 tile
    final int scale = 3; // scale the tile by 3

    final int tileSize = originalTileSize * scale; // 48x48 tile
    final int maxScreenCol = 20; // 16 tiles wide
    final int maxScreenRow = 16; // 16 tiles tall

    final int screenWidth = tileSize * maxScreenCol; // 960 pixels wide
    final int screenHeigth = tileSize * maxScreenRow; // 768 pixels tall

    Thread gameThread; // thread to run the game

    public gamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeigth)); // set the size of the panel
        this.setBackground(Color.BLACK); // set the background color of the panel
        this.setDoubleBuffered(true); // to prevent flickering
    }

    public void startGameThread() { // start the game thread

        gameThread = new Thread(this); // create a new thread
        gameThread.start(); // start the thread


    }

    @Override
    public void run() { // run the game
        while (gameThread != null){ // while the game thread is running
            // System.out.println("Game is running");

            // 1 UPDATE: update info such as characters positions
            update();

            // 2 DRAW: draw the updated info on the screen
            repaint();

        }
    }

    public void update(){

    }

    public void paintComponent ( Graphics g){

        super.paintComponent(g); // call the paintComponent method from the parent class

        Graphics2D g2 = (Graphics2D) g; // cast the graphics object to graphics2d

        g2.setColor(Color.white); // set the color to white

        g2.fillRect(100, 100, tileSize, tileSize); // draw a white rectangle at 100, 100

        g2.dispose(); // dispose the graphics object
    }
}
