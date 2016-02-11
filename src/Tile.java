import javafx.scene.layout.StackPane;
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
    Rectangle square = new Rectangle(25,25, Paint.valueOf("BLUE"));
    Text valueString = new Text();

    public Tile(int xLocation, int yLocation) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.value = newValue();

        //building the Tiles graphical components
        valueString.setText(Integer.toString(this.value));
        this.getChildren().addAll(square, valueString);
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
            return 2;
        }
        else{
            return 4;
        }
    }
}
