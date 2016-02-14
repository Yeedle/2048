import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

/**
 * Created by Yeedle on 2/14/2016 1:07 PM.
 */
public class TileAnimation {

    private TranslateTransition[] translateTransitions;
    //TODO: This class should perhaps provide only static methods.
    /**
     * Constructor
     * Takes a list of Tiles and creates a TranslateTransition for each one
     * @param tiles a variable number of tiles to be animated
     */
    public TileAnimation(Tile... tiles)
    {
        int numOfTiles = tiles.length; // get the number of tiles passed in

        // fill an array with a TranslateTransition for each tile
        translateTransitions = new TranslateTransition[numOfTiles];
        for (int i = 0; i < numOfTiles ; i++)
        {
            translateTransitions[i] = new TranslateTransition(Duration.millis(200), tiles[i]);
        }
    }

    /**
     * creates a parallelTransition for all the TranslateTransitions
     */
    public void playAnimations(){
        ParallelTransition pt = new ParallelTransition(translateTransitions);

        pt.play();
    }

}
