import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 * Created by Modi on 2/13/2016.
 */
public class EmptyTile extends AbstractTile {

    public EmptyTile() {
        super();
        square.getStyleClass().add("tile-empty");
    }


    public boolean containsTile() {
        for (Node node : this.getChildren()) {
            if (node instanceof Tile)
                return true;
        }
        return false;
    }
}
