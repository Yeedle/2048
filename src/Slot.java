import javafx.scene.Node;

/**
 * Created by Modi on 2/13/2016.
 */
public class Slot extends AbstractTile {

    private Tile tile = new Tile();

    /**
     * Constructor
     * sets the style class to look like an empty tile
     */
    public Slot() {
        super();
        square.getStyleClass().add("tile-empty");

        this.getChildren().add(tile);
    }


    /*
    * creates a new tile after a tile was moved.
     */
    public void newTile()
    {
        this.getChildren().remove(tile);

        if (tileValue() == 0)
        {
            tile = new Tile();
        }
        else
        {
            tile = new Tile(tileValue());
        }
      this.getChildren().add(tile);
    }

    /**
     * Checks if a slot contains a tile
     * @return true if slot contains tile, false if not
     */
    public boolean containsTile() {
        for (Node node : this.getChildren()) {
            if (node instanceof Tile)
                return true;
        }
        return false;
    }

    /**
     * returns the value of a tile living inside a slot
     * @return the value of the tile or -1 if something went wrong
     */
    public int tileValue() {

        return tile.getValue();
    }

    /**
     *
     * @param tile Tile to add to slot
     */
    public void add(Tile tile){
        this.getChildren().add(tile);
    }

    public void newTileValue()
    {
        tile.newValue();
    }

    public Tile getTile() {
        return tile;
    }

}
