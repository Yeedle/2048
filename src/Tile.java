import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Random;

/**
 * Created by Modi on 2/9/2016.
 */
public class Tile extends StackPane {
    int value;
    int xLocation;
    int yLocation;
    private final double WIDTH = 106.25;
    private final double HEIGHT = 106.25;
    Rectangle square = new Rectangle(WIDTH, HEIGHT);
    Label valueLabel = new Label();

    public Tile(int xLocation, int yLocation) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.value = newValue();

        //building the Tile's graphical components
        valueLabel.setText(Integer.toString(this.value));
        valueLabel.setStyle("-fx-font-size: 55px; " +
                            "-fx-font-family: 'Clear Sans', 'Helvetica Neue', Arial, sans-serif; " +
                            "-fx-font-weight: bold;" +
                            "-fx-text-fill: #776e65;");
        square.setArcHeight(7);
        square.setArcWidth(7);
        this.getChildren().addAll(square, valueLabel);
    }



    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int[] getLocation() {
        return new int[]{xLocation, yLocation};
    }

    public void setLocation(int xLocation, int yLocation) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    public int newValue(){
        if(Math.random() > .5){
            square.setFill(Color.valueOf("#eee4da"));
            return 2;
        }
        else{
            square.setFill(Color.valueOf("#ede0c8"));
            return 4;
        }
    }
}
