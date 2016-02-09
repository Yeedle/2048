import java.util.Random;

/**
 * Created by Modi on 2/9/2016.
 */
public class Tile {
    int value;
    int xLocation;
    int yLocation;

    public Tile(int xLocation, int yLocation) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.value = newValue();
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
