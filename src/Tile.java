import java.util.Random;

/**
 * Created by Modi on 2/9/2016.
 */
public class Tile {
    int value;
    int[] location = new int[2];

    public Tile(int[] location) {
        this.location = location;
        this.value = newValue();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int[] getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        this.location = location;
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
