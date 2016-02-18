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


    AbstractTile[][] tileArray = new AbstractTile[4][4];
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

    // adds all the nodes from the board into a 2D array for easy traversal and comparison
    private void addTilesToArray (){
        for (int i = 0; i < 16; i++) {
            AbstractTile at = (AbstractTile)(this.getChildren().get(i));
            if (i < 4){
                tileArray[0][i] = at;
            }
            else if (i < 8){
                tileArray[1][i - 4] = at;
            }
            else if (i < 8){
                tileArray[2][i - 8] = at;
            }
            else{
                tileArray[3][i - 12] = at;
            }
        }
    }

    private <T extends AbstractTile> void addTile(T tile){

        this.getChildren().add(tile);

    }

    public void initializeBoard() {
        // TODO: 2/16/2016 empty the board when initializing after a game over or clicking the new game button

        for (int i = 0; i < 2; i++) {
            addNewTile();
        }

    }


    //the board handles the four basic moves in the game: up, down, left, and right
    protected void movedUp() {
        //TODO: handle the up move
        System.out.println("movedUp");
       // if no move available, do nothing
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

    /**
     * Adds a new tile to the board. If there's only one slot left, add a tile and checkIfOtherMoveAvailable()
     */
    private void addNewTile() {

        ObservableList<Slot> emptySlots = getEmptySlots();
        int numOfEmptySlots = emptySlots.size();

        if (numOfEmptySlots > 1) {
            Random rand = new Random();
            int randTile = rand.nextInt(numOfEmptySlots);
            Slot emptySlot = emptySlots.get(randTile);
            emptySlot.add(new Tile());
        } else {
            emptySlots.get(0).add(new Tile());
            checkIfOtherMoveAvailable();
        }


    }

    /**
     * checks if there are moves left. If there are none, calls gameOver.
     */
    private void checkIfOtherMoveAvailable() {
        //TODO: calculate if a move is possible, if not, call gameOver();
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
