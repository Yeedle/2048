import javafx.animation.ScaleTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Created by Modi on 2/9/2016.
 */
public class Tile extends AbstractTile {
    int value;
    Label valueLabel = new Label();

    public Tile() {
        super();
        this.value = newValue();

        //building the Tile's graphical components
        valueLabel.setText(Integer.toString(this.value));
        valueLabel.getStyleClass().add("tile-label");

        animateTileCreation();

        this.getChildren().add(valueLabel);

    }

    private void animateTileCreation() {
        ScaleTransition st = new ScaleTransition(Duration.millis(500), this);
        st.setFromX(.3);
        st.setFromY(.3);
        st.setToX(1);
        st.setToY(1);
        st.play();
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
