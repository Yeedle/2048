import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;

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
            this.addTile(new Slot());
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
        StackPane sp = (StackPane)(this.getChildren().get(i));// returns the Slot, and adds a Tile to it
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
        ObservableList<Slot> emptySlots = getEmptySlots();
        int numOfEmptySlots = emptySlots.size();

        if (numOfEmptySlots > 0) {
            Random rand = new Random();
            int randTile = rand.nextInt(numOfEmptySlots);
            Slot emptySlot = emptySlots.get(randTile);
            emptySlot.add(new Tile());
        } else {
            gameOver();
        }


    }


    private void gameOver() {
        //TODO: handle game over
    }

    /**
     *
     * @return a list of the Slot children without a Tile in them
     */
    private ObservableList<Slot> getEmptySlots() {


       ObservableList<Slot> allSlots = getAllSlots();

        for (int i = 0; i < allSlots.size(); i++){
            if (allSlots.get(i).containsTile()){
                allSlots.remove(i--);
            }

        }

        return allSlots;
    }

    /**
     * Gets all the nodes of the board, selects only the empty slots and returns them as an ObservableList
     * @return all the Slot nodes of the board
     */
    private ObservableList<Slot> getAllSlots() {
        ObservableList<Slot> allSlots = FXCollections.observableArrayList();
        for (Node node : tiles){
            if (node instanceof Slot)
                allSlots.add((Slot) node);
        }
        return allSlots;
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
