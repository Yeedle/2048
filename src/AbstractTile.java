import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

/**
 * A template for all sorts of Tiles
 * Created by Modi on 2/13/2016.
 */
    public abstract class AbstractTile extends StackPane{

        protected static final double WIDTH = 110.0;
        protected static final double HEIGHT = 110.0;
        protected Rectangle square;


    /**
     * Constructor
     *
     * creates a rectangle and a label and adds it to the Tile.
     * Adds the style class "tile" to the tile.
     */
    protected AbstractTile()
    {
        square = new Rectangle(WIDTH, HEIGHT);
        square.getStyleClass().add("tile");
        this.getChildren().addAll(square);
    }

    //TODO: Get rid of this getValue method. Slots won't have any value, and will only serve as containers for tiles
    /**
     * gets value of tile. 0 if tile is not an instance of Tile
     * @return the value of the tile. 0 if the tile is not an instance of Tile
     */
   /* public int getValue(){
        if (this instanceof Slot)
            return 0;
        else {
            Tile tile = (Tile)this;
            return tile.getValue();
        }
    }
*/
}
