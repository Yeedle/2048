import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

/**
 * Created by Yeedle on 2/9/2016 10:10 AM.
 */
public class Board extends TilePane {



    ObservableList<Node> tiles = this.getChildren();

    // constructor builds graphical componentes
    //TODO: perphps this class can be split up into two classes (inheriting one another?), one for the logic and one for the graphics
    public Board() {
        addEmptyTiles();
        this.getStyleClass().add("board");
        initializeBoard();

    }


    /**
     * Fills the board with empty tiles
     */
    private void addEmptyTiles() {

        final int NUM_OF_TILES = 16;

        for (int i = 0; i < NUM_OF_TILES; i++) {
            this.addTile(new EmptyTile());
        }

    }


    private <T extends AbstractTile> void addTile(T tile){

        this.getChildren().add(tile);

    }

    public void initializeBoard() {
        //TODO: we should use the same method that adds new tiles (another 'TODO') to call it twice to initialize the board
        for (int i = 0; i < 2; i++) {
            addNewTile();
        }
        //game starts by creating two tiles and placing them randomly on the board
       /*Random rand = new Random();
        int i = rand.nextInt(16);
        int j = rand.nextInt(16);

        while (i == j){ //verify that i and j don't have the same value
            j = rand.nextInt(16);
        }

        // following code needs a refactor, perhaps break it up into smaller methods
        StackPane sp = (StackPane)(this.getChildren().get(i));// returns the EmptyTile, and adds a Tile to it
        sp.getChildren().add(new Tile());
        sp = (StackPane)(this.getChildren().get(j));
        sp.getChildren().add(new Tile());*/
    }


    //the board handles the four basic moves in the game: up, down, left, and right
    protected void movedUp() {
        //TODO: handle the up move
        System.out.println("movedUp");
        //after move is over, generate new tile and place in on board
        addNewTile();
    }


    protected void movedDown() {

        //TODO: handle the down move
        System.out.println("moveddown");
        //after move is over, generate new tile and place in on board
        addNewTile();
    }

    protected void movedLeft() {

        //TODO: handle the left move

        //after move is over, generate new tile and place in on board
        addNewTile();
    }

    protected void movedRight() {

        //TODO: handle the right move

        //after move is over, generate new tile and place in on board
        addNewTile();
    }

    private void addNewTile() {
        //TODO: logic for addin a new tile randomly on an empty spot on the board, and to call gameover if no empty spot left
        //algorithm: find all the empty tiles on the board; choose one randomly; add a Tile to it;
        ObservableList<EmptyTile> emptyTiles = getEmptyTileChildren();
        Random rand = new Random();
        EmptyTile et = emptyTiles.get(rand.nextInt(16));
        et.getChildren().add(new Tile());



    }

    /**
     *
     * @return a list of the EmptyTile children without a Tile in them
     */
    private ObservableList<EmptyTile> getEmptyTileChildren() {


       ObservableList<EmptyTile> emptyTiles = getTileChildern();
        for (int i = 0; i < emptyTiles.size(); i++){
            if (emptyTiles.get(i).containsTile())
                emptyTiles.remove(i);
        }
        return emptyTiles;
    }

    /**
     *
     * @return all the EmptyTile nodes of the board
     */
    private ObservableList<EmptyTile> getTileChildern() {
        ObservableList<EmptyTile> ol = FXCollections.observableArrayList();
        for (Node node : tiles){
            if (node instanceof EmptyTile)
                ol.add((EmptyTile) node);
        }
        return ol;
    }

    public void moved(KeyEvent ke) {
        switch (ke.getCode()) {
            case UP:
                movedUp();
                break;
            case DOWN:
                movedDown();
                break;
            case LEFT:
                movedLeft();
                break;
            case RIGHT:
                movedRight();
                break;
            default:
                break;
        }
    }


    //TODO: We need to figure out how to keep track of spaces not occupied by tiles.

}
