package entity;

import java.awt.image.BufferedImage;

public class entity {

    public int x, y; // position of the entity
    public int speed; // speed of the entity

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2; // images for the entity
    public String direction; // direction of the entity

    public int spriteCounter = 0; // sprite count
    public int spriteNum = 1; // number of sprites

}
