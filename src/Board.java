import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

/**
 * Created by Yeedle on 2/9/2016 10:10 AM.
 */
public class Board extends TilePane {

    Random rand = new Random();
    private Tile[] tiles = new Tile[16];

    // constructor builds graphical componentes
    //TODO: perphps this class can be split up into two classes (inheriting one another?), one for the logic and one for the graphics

    public Board(){
        addEmptyTiles();
        this.getStyleClass().add("board");
        initializeBoard();
    }


    private void addEmptyTiles() {
        for (int i=0; i<16; i++)
        {
            this.getChildren().add(new EmptyTile());
        }

    }

    public void initializeBoard() {
        //game starts by creating two tiles and placing them randomly on the board
        int i = rand.nextInt(16);
        int j = rand.nextInt(16);

        while (i == j){ //verify that i and j don't have the same value
            j = rand.nextInt(16);
        }

        // following code needs a refactor, perhaps break it up into smaller methods
        StackPane sp = (StackPane)(this.getChildren().get(i));// returns the EmptyTile, and adds a Tile to it
        sp.getChildren().add(new Tile());
        sp = (StackPane)(this.getChildren().get(j));
        sp.getChildren().add(new Tile());
    }

    
    //the board handles the four basic moves in the game: up, down, left, and right
    private void movedUp(){
        //TODO: handle the up move
        
        //after move is over, generate new tile and place in on board
    }
    
    private void movedDown(){

        //TODO: handle the down move

        //after move is over, generate new tile and place in on board
    }
    
    private void movedLeft(){

        //TODO: handle the left move

        //after move is over, generate new tile and place in on board
    }
    
    private void movedRight(){

        //TODO: handle the right move

        //after move is over, generate new tile and place in on board
    }

    //TODO: We need to figure out how to keep track of spaces not occupied by tiles.
    
    
}
