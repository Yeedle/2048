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

    /**
     * Used to construct empty tiles at the beginninf of the game
     */
    public Tile()
    {
        super();

        value = 0;

        TileAnimation.animateTileCreation(this);

    }


    public Tile(int value)
    {
        super();
        square.getStyleClass().add("tile-empty");
        this.value = 0;
        this.valueLabel = new Label();
        valueLabel.getStyleClass().add("tile-label");
        //building the Tile's graphical components
        this.getChildren().add(valueLabel);

        TileAnimation.animateTileCreation(this);
    }




    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public void newValue(){

        square.getStyleClass().remove("tile-empty");
        if(Math.random() < 0.9 ){

            square.getStyleClass().add("tile-2"); //adds a css class to the square
            setValue(2);
            valueLabel.setText(Integer.toString(this.value));
        }
        else{
            square.getStyleClass().add("tile-4"); //adds a css class to the square
            setValue(4);
            valueLabel.setText(Integer.toString(this.value));
        }
    }
}
