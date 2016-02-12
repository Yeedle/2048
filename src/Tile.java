import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

/**
 * Created by Modi on 2/9/2016.
 */
public class Tile extends StackPane {
    int value;
    int xLocation;
    int yLocation;
    private final double WIDTH = 110.0;
    private final double HEIGHT = 110.0;
    Rectangle square = new Rectangle(WIDTH, HEIGHT);
    Label valueLabel = new Label();

    public Tile(int xLocation, int yLocation) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.value = newValue();

        //building the Tile's graphical components
        valueLabel.setText(Integer.toString(this.value));
        valueLabel.getStyleClass().add("tile-label");

        square.getStyleClass().add("tile"); //adss css class

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
        if(Math.random() > 0.9 ){
            square.getStyleClass().add("tile-2"); //adds a css class to the square
            return 2;
        }
        else{
            square.getStyleClass().add("tile-4"); //adds a css class to the square
            return 4;
        }
    }
}
