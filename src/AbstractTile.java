import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

/**
 * Created by Modi on 2/13/2016.
 */
    public abstract class AbstractTile extends StackPane{
        private static final double WIDTH = 110.0;
        private static final double HEIGHT = 110.0;
        protected Rectangle square;


    protected AbstractTile(){
        square = new Rectangle(WIDTH, HEIGHT);
        square.getStyleClass().add("tile");

       this.getChildren().add(square);
    }
}
