import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

/**
 * Created by Yeedle on 2/14/2016 1:07 PM.
 */
public class TileAnimation {

    private TranslateTransition[] translateTransitions;

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


    public void playAnimations(){
        ParallelTransition pt = new ParallelTransition(translateTransitions);

        pt.play();
    }

}
