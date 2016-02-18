import javafx.animation.ScaleTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Created by Modi on 2/9/2016.
 */
public class Tile extends AbstractTile {

   private int value;
    private Label valueLabel;

    public Tile() {
        super();

        this.value = newValue();
       this.valueLabel = new Label();

        //building the Tile's graphical components
        this.getChildren().add(valueLabel);
        valueLabel.setText(Integer.toString(this.value));
        valueLabel.getStyleClass().add("tile-label");

        TileAnimation.animateTileCreation(this);

    }




    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public int newValue(){
        if(Math.random() < 0.9 ){
            square.getStyleClass().add("tile-2"); //adds a css class to the square
            return 2;
        }
        else{
            square.getStyleClass().add("tile-4"); //adds a css class to the square
            return 4;
        }
    }
}
