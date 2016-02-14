import javafx.animation.ScaleTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * A template for all sorts of Tiles
 * Created by Modi on 2/13/2016.
 */
    public abstract class AbstractTile extends StackPane{
        int value;
        private static final double WIDTH = 110.0;
        private static final double HEIGHT = 110.0;
        protected Rectangle square;
        Label valueLabel;

    /**
     * Constructor
     *
     * creates a rectangle and a label and adds it to the Tile.
     * Adds the style class "tile" to the tile.
     */
    protected AbstractTile(){
        square = new Rectangle(WIDTH, HEIGHT);
        square.getStyleClass().add("tile");

        valueLabel = new Label();

        this.getChildren().addAll(square, valueLabel);
    }
}
