import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

/**
 * Created by Modi on 2/13/2016.
 */
    public abstract class AbstractTile extends StackPane{
        private final double WIDTH = 110.0;
        private final double HEIGHT = 110.0;
        Rectangle square = new Rectangle(WIDTH, HEIGHT);
        StackPane sp = new StackPane(square);
}
