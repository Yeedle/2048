import javafx.animation.Animation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Random;

/**
 * Created by Yeedle on 2/9/2016 10:10 AM.
 */
public class Board extends TilePane {

    final int ROWS = 4;
    final int COLUMNS = 4;
    Tile[][] tileArray = new Tile[ROWS][COLUMNS];

    // constructor builds graphical componentes
    public Board()
    {
        addSlots();

        this.getStyleClass().add("board");

        initializeBoard();
    }

    /**
     * fills the board with Slots.
     */
    private void addSlots()
    {
        final int NUM_OF_TILES = 16;

        for (int i = 0; i < NUM_OF_TILES; i++) {
            addSlot(new Slot());
        }
    }

    public void initializeBoard() {
        // TODO: 2/16/2016 empty the board when initializing after a game over or clicking the new game button

        for (int i = 0; i < 2; i++) {
            addNewTile();
        }
    }

    /**
     * adds all the nodes from the board into a 2D array for easy traversal and comparison
     */
    private void addTilesToArray ()
    {
        ObservableList<Slot> slots = getAllSlots();

        for (int i = 0; i < slots.size(); i++) {
            Slot slot = slots.get(i);
            Tile tile = slot.getTile();
            int row = i<4? 0 : i<8? 1 : i<12? 2 : 3; //is i<4? then row =0: else, is i<8? then row=1: else ...
                tileArray[row][i%4] = tile;
        }
    }



    /**
     * returns a tile of the board based on index
     * @param index
     * @return
     */
    private Tile getTile(int index)
    {
            return (Tile)this.getChildren().get(index);
    }

    private void addSlot(Slot slot)
    {
        this.getChildren().add(slot);
    }

    private void addTile(Tile tile, int slotNumber)
    {
        Slot currentSlot = (Slot)this.getChildren().get(slotNumber);
        currentSlot.add(tile);
    }




    /**
     * handles all moves. Sends the tileArray to the model, plus the direction. If the model returns true
     * it loops through the array of tiles, finds the transitions, and adds them to the TileAnimation transition
     * array. Then, it calls the playAnimations method
     */
    protected void moved(Direction direction)
    {
        if ( Model.move(tileArray, direction))
            for (Tile[] row : tileArray)
                for (Tile tile : row)
                    if (tile.getTransition() > 0) {
                        TileAnimation.moveTile(tile, tile.getTransition(), direction);
                        tile.setTransition(0);
                    }

        TileAnimation.playAnimations();
    }

    /**
     * Adds a new tile to the board. If there's only one slot left, add a tile and checkIfOtherMoveAvailable()
     */
    protected void addNewTile()
    {

        ObservableList<Slot> emptySlots = getSlotsWithEmptyTiles();

        int numOfEmptySlots = emptySlots.size();

        if (numOfEmptySlots > 1) {
            Random rand = new Random();
            int randSlot = rand.nextInt(numOfEmptySlots);
            Slot emptySlot = emptySlots.get(randSlot);
            emptySlot.newTileValue();
            TileAnimation.animateTileCreation(emptySlot.getTile());
        } else {
            emptySlots.get(0).newTileValue();
            checkIfOtherMoveAvailable();
        }

        // rebuild array model
        addTilesToArray();
    }

    /**
     * checks if there are moves left. If there are none, calls gameOver.
     */
    private void checkIfOtherMoveAvailable()
    {
        if (!Model.checkPossibleMerge(tileArray))
        {
            gameOver();
        }
    }


    private void gameOver() {
        //TODO: handle game over
        System.out.println("game over");
    }


    private ObservableList<Slot> getSlotsWithEmptyTiles() {


        ObservableList<Slot> emptySlots = getAllSlots();

        for (int i = 0; i < emptySlots.size(); i++)
        {
            if (emptySlots.get(i).tileValue() != 0){
                emptySlots.remove(i--);
            }

        }

        return emptySlots;
    }

    /**
     * Gets all the nodes of the board cast them into Slots and returns them as an ObservableList
     * @return all the Slot nodes of the board
     */
    private ObservableList<Slot> getAllSlots()
    {
        ObservableList<Slot> allSlots = FXCollections.observableArrayList();
        for (Node node : this.getChildren()){
            if (node instanceof Slot) //for security, perhaps not needed since we know they'll be Slots
                allSlots.add((Slot) node);
        }
        return allSlots;
    }

    public void moved(KeyEvent ke) {
        switch (ke.getCode()) {
            case UP:
                moved(Direction.UP);
                break;
            case DOWN:
                moved(Direction.DOWN);
                break;
            case LEFT:
                moved(Direction.LEFT);
                break;
            case RIGHT:
                moved(Direction.RIGHT);
                break;
            default:
                break;
        }
    }

    public Tile[][] getTileArray() {
        return tileArray;
    }

}
