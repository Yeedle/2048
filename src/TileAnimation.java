import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

/**
 * Created by Yeedle on 2/14/2016 1:07 PM.
 */
public class TileAnimation {

    private ParallelTransition pt = new ParallelTransition();

    /**
     * moveTile calculates the pixels to be moved, then calls the addToTransitions method
     * @param tile
     * @param numberOfTilesToMove
     * @param direction
     */
    public void moveTile(Tile tile, int numberOfTilesToMove, Direction direction){

        // if it gets moved in the negative direction, we add a negative sign
        if (direction.equals(Direction.DOWN) || direction.equals(Direction.LEFT))
        {
            numberOfTilesToMove = -numberOfTilesToMove;
        }

        double pixels = calculatePixelsBasedOn(numberOfTilesToMove);

        addToTransitionsList(tile, pixels, direction);

    }

    /**
     * Calculates number of pixels to move tiles, based on numer of tiles to move
     * @param numberOfTilesToMove negative if they are going down or left
     * @return the amount of pixels to move the tile
     */
    protected double calculatePixelsBasedOn(int numberOfTilesToMove) {
        return (numberOfTilesToMove * Tile.WIDTH) + (numberOfTilesToMove * 30); // 30 is the number of pixels between each tile (padding + gaps)
        //todo figure out how to get the padding between each tile programmatically
    }

    /**
     * Adds the passed tile to the ParallelTransition's list
     * @param tile
     * @param pixels
     * @param direction
     */
    private void addToTransitionsList(Tile tile, double pixels, Direction direction) {

        TranslateTransition t = new TranslateTransition(Duration.millis(200), tile);
        if (direction.equals(Direction.UP) || direction.equals(Direction.DOWN))
            t.setByY(pixels);
        else
            t.setByX(pixels);
        pt.getChildren().add(t);
    }


    /**
     * plays the parallelTransition for all the TranslateTransitions accumulated in pt
     */
    public void playAnimations(){

        pt.play();
        pt.setOnFinished(e -> pt.getChildren().removeAll());
    }

    /**
     * Animates the addition of tiles to the board
     * @param tile to be animated
     */
    public static void animateTileCreation(Tile tile) {
        ScaleTransition st = new ScaleTransition(Duration.millis(500), tile);
        st.setFromX(.3);
        st.setFromY(.3);
        st.setToX(1);
        st.setToY(1);
        st.play();
    }

}
