import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 * Created by Modi on 2/13/2016.
 */
public class Slot extends AbstractTile {

    /**
     * Constructor
     * sets the style class to look like an empty tile
     */
    public Slot() {
        super();
        square.getStyleClass().add("tile-empty");
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
     *
     * @param tile Tile to add to slot
     */
    public void add(Tile tile){
        this.getChildren().add(tile);
    }
}
