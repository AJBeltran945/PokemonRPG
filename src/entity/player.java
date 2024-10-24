package entity;
import main.gamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class player extends entity {

    gamePanel gp; // game panel
    KeyHandler keyH; // key handler

    public player(gamePanel gp, KeyHandler keyH) { // constructor
        this.gp = gp; // set the game panel
        this.keyH = keyH; // set the key handler

        setDefautlValues(); // set the default values
        getPlayerImage(); // get the player image
    }

    public void setDefautlValues() { // set the default values
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage() { // get the player image
        try {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_up_1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_up_2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_down_1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_down_2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_left_1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_left_2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_right_1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_right_2.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() { // update the player
        if (keyH.up) { // if the up key is pressed
            direction = "up"; // set the direction to up
            y -= speed; // move the player up
        }
        if (keyH.down) { // if the down key is pressed
            direction = "down"; // set the direction to down
            y += speed; // move the player down
        }
        if (keyH.left) { // if the left key is pressed
            direction = "left"; // set the direction to left
            x -= speed; // move the player left
        }
        if (keyH.right) { // if the right key is pressed
            direction = "right"; // set the direction to right
            x += speed; // move the player right
        }

        spriteCounter++; // increment the sprite counter
        if (spriteCounter > 12){
            if (spriteNum == 1){
                spriteNum = 2;
            }
            else if (spriteNum == 2){
                spriteNum = 1;
            }
        }
    }

    public void draw(Graphics g2) { // draw the player
        BufferedImage image = null; // image to draw

        switch (direction){
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null); // draw the image
    }
}
