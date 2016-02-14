import javafx.scene.layout.StackPane;

/**
 * Created by Modi on 2/13/2016.
 */
public class EmptyTile extends AbstractTile {

    public EmptyTile() {
        square.getStyleClass().addAll("tile", "tile-empty");
    }
}
