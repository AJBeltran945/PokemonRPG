package entity;
import main.gamePanel;
import main.KeyHandler;

public class player extends entity {

    gamePanel gp;
    KeyHandler keyH;

    public player(gamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
    }
}
