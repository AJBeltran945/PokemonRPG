package main;
import javax.swing.JFrame;

public class main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to close properly
        window.setResizable(false); // to prevent resizing
        window.setTitle("Pokemon RPG game"); // title of the window

        gamePanel gamePanel = new gamePanel(); // create a new gamePanel object
        window.add(gamePanel); // add the gamePanel to the window

        window.pack();

        window.setLocationRelativeTo(null); // to center the window
        window.setVisible(true); // to make the window visible

        gamePanel.startGameThread(); // start the game thread
    }
}
