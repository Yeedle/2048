import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Yeedle on 2/9/2016 10:10 AM.
 */
public class Board extends TilePane {


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
            this.getChildren().add(new EmptyTile().sp);
        }

    }

    public void initializeBoard() {
        //// TODO: 2/10/2016 handle initalization of baord
        //game starts by creating two tiles and placing them randomly on the board
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
