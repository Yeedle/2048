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
    private int transition;
    private Label valueLabel;
    boolean isCombination;

    public boolean isCombination(){
        return isCombination;
    }

    public void wasCombinated(){
        this.isCombination = true;
    }

    public void resetIsCombination(){
        this.isCombination = false;
    }

    /**
     * Used to construct empty tiles at the beginninf of the game
     */
    public Tile()
    {
        super();
        square.getStyleClass().add("tile-empty");
        value = 0;

        this.valueLabel = new Label();
       valueLabel.getStyleClass().addAll("tile-label", "tile-label-black", "tile-label-one-digit");

        //valueLabel.setText(Integer.toString(value));
      //  updateValueLabel();
        this.getChildren().add(valueLabel);

    //    TileAnimation.animateTileCreation(this);

    }


    public Tile(int value)
    {
        super();

        String styleClass = "tile-" + Integer.toString(value);
        square.getStyleClass().add(styleClass);
        this.value = value;
        this.valueLabel = new Label();
        valueLabel.setText(Integer.toString(value));


        String color = "black";
        if (value > 4)
        {
            color = "white";
        }
        String labelTextColorStyleClass = "tile-label-" + color;
        int numOfDigitsInValue = String.valueOf(value).length();
        String labelTextSizeStyleClass = "tile-label-" + Integer.toString(numOfDigitsInValue);

        valueLabel.getStyleClass().addAll("tile-label", labelTextColorStyleClass, labelTextSizeStyleClass);

        //building the Tile's graphical components
        this.getChildren().add(valueLabel);

      //  TileAnimation.animateTileValueChanging(this);
    }




    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;

    }

    public void updateValueLabel(){
        String newStyleClass = "tile-" + Integer.toString(value);

        square.getStyleClass().remove(1);
        square.getStyleClass().add(newStyleClass);

        valueLabel.getStyleClass().remove(1, 3);
        String color = "black";
        if (value > 4)
        {
            color = "white";
        }
        String labelTextColorStyleClass = "tile-label-" + color;
        int numOfDigitsInValue = String.valueOf(value).length();
        String labelTextSizeStyleClass = "tile-label-" + Integer.toString(numOfDigitsInValue);

        valueLabel.getStyleClass().addAll("tile-label", labelTextColorStyleClass, labelTextSizeStyleClass);


        this.valueLabel.setText(Integer.toString(this.value));
    }



    public void newValue(){

        square.getStyleClass().remove("tile-empty");
        if(Math.random() < 0.9 ){

            square.getStyleClass().add("tile-2"); //adds a css class to the square
            this.value =2;


       //     this.getChildren().add(valueLabel);
        }
        else{
            square.getStyleClass().add("tile-4"); //adds a css class to the square
            this.value = 4;

        }
        updateValueLabel();
    }

    public int getTransition() {
        return transition;
    }

    public void setTransition(int transition) {
        this.transition = transition;
    }


}
