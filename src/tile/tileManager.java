package tile;

import main.gamePanel;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Objects;

import javax.imageio.ImageIO;

public class tileManager {

    gamePanel gp; // game panel
    tile[] tile; // array of tiles
    int mapTileNum [][]; // map tile number

    public tileManager(gamePanel gp) { // constructor

        this.gp = gp; // set the game panel

        tile = new tile[10]; // create a new array of tiles
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow]; // create a new array of map tile numbers

        getTileImage(); // call the getTileImage method
        loadMap(); // call the loadMap method
    }

    public void getTileImage() { // get the tile image
        try {
            tile[0] = new tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass_1.png")));

            tile[1] = new tile();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass_2.png")));

            tile[2] = new tile();
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/path_1.png")));

            tile[3] = new tile();
            tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/path_2.png")));

            tile[4] = new tile();
            tile[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/inner_water.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("/maps/map01.txt");// load the map file
            BufferedReader br = new BufferedReader(new InputStreamReader(is));// create a new buffered reader

            int col = 0; // column
            int row = 0; // row

            while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
                String line = br.readLine(); // read a line from the file

                while (col < gp.maxScreenCol) {

                    String numbers[] = line.split(" "); // split the line by spaces

                    int num = Integer.parseInt(numbers[col]); // get the first number

                    mapTileNum[col][row] = num; // set the map tile number
                    col++; // increment the column
                }
                if (col == gp.maxScreenCol) {
                    col = 0; // reset the column
                    row++; // increment the row
                }
            }

            br.close(); // close the buffered reader

        } catch (Exception e) {
        }
    }

    public void draw(Graphics2D g2) { // draw the tiles

        int col = 0; // column
        int row = 0; // row
        int x = 0; // x position
        int y = 0; // y position

        while (col < gp.maxScreenCol && row < gp.maxScreenRow){

            int tileNum = mapTileNum[col][row]; // get the tile number

            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if (col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
}
