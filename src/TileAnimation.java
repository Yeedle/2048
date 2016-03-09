import com.sun.javafx.css.Stylesheet;
import javafx.animation.*;
import javafx.css.CssMetaData;
import javafx.geometry.Insets;
import javafx.util.Duration;

/**
 * Created by Yeedle on 2/14/2016 1:07 PM.
 */
public class TileAnimation {

    private static ParallelTransition pt = new ParallelTransition();

    /**
     * moveTile calculates the pixels to be moved, then calls the addToTransitions method
     * @param tile
     * @param numberOfTilesToMove
     * @param direction
     */
    public static void moveTile(Tile tile, int numberOfTilesToMove, Direction direction){

        // if it gets moved in the negative direction, we add a negative sign
        if (direction.equals(Direction.UP) || direction.equals(Direction.LEFT))
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
    protected static double calculatePixelsBasedOn(int numberOfTilesToMove) {

       Stylesheet stylesheet = new Stylesheet("stylesheet.css");

        System.out.println( stylesheet.getRules().size());

        return (numberOfTilesToMove * Tile.WIDTH) + (numberOfTilesToMove * 15); // 15 is the number of pixels between each tile (padding + gaps)

    }

    /**
     * Adds the passed tile to the ParallelTransition's list
     * @param tile to be transitioned
     * @param pixels the tile will be moved
     * @param direction the tile will be moved in
     */
    private static void addToTransitionsList(Tile tile, double pixels, Direction direction) {

        TranslateTransition t = new TranslateTransition(Duration.millis(150), tile);
        t.setInterpolator(Interpolator.EASE_IN);
        if (direction.equals(Direction.UP) || direction.equals(Direction.DOWN))
            t.setByY(pixels);
        else
            t.setByX(pixels);
        pt.getChildren().add(t);
    }


    /**
     * plays the parallelTransition for all the TranslateTransitions accumulated in pt
     */
    public static boolean playAnimations()
    {
        if (pt.getChildren().size() == 0)
            return false;
        else {
            pt.play();
            pt.setOnFinished(e -> finishedAnimation());
            return true;
        }
    }

    /**
     * Get's the board that called the animation, notifies the board that the animation was finished, then
     * clears the Parallel Transitions array.
     */
    public static void finishedAnimation()
    {
        Board board = getBoard();

        for (Slot slot : animatedSlots())
        {
            board.animationOfTileFinished(slot);
        }

        pt.getChildren().clear();

        board.animationsFinished();
    }

    /**
     * Returns all the slots on the board on which transitions were performed
     * @return Slot[]
     */
    private static Slot[] animatedSlots() {
        Slot[] slots = new Slot[pt.getChildren().size()];

        int i =0;

        for (Animation animation : pt.getChildren())
        {
            Slot slot = getSlotFrom((TranslateTransition) animation);
            slots[i++] = slot;
        }
        return slots;
    }


    /**
     * returns the board that summoned the animation.
     * Caution: this method can only be called if pt has at least on transition in it.
     * @return Board
     */
    private static Board getBoard()
    {
        Slot slot = getSlotFrom((TranslateTransition) pt.getChildren().get(0));
        return (Board) slot.getParent();
    }

    /**
     * Extracts the slot on which a transition animation was performed
     * @param transition
     * @return Slot
     */
    private static Slot getSlotFrom(TranslateTransition transition) {
        Tile tile = (Tile)transition.getNode();
        return (Slot)tile.getParent();
    }

    /**
     * Animates the appearance of tiles to the board
     * @param tile to be animated
     */
    public static void appearAnimation(Tile tile) {
        ScaleTransition st = new ScaleTransition(Duration.millis(200), tile);
        st.setFromX(.3);
        st.setFromY(.3);
        st.setToX(1);
        st.setToY(1);
        st.setInterpolator(Interpolator.SPLINE(0.25, 0.1, 0.25, 0.1));
        st.play();
    }

    /**
     * animates the change of tile values.
     * @param tile to be animated
     */
    public static void popAnimation(Tile tile) {
        ScaleTransition st = new ScaleTransition(Duration.millis(150), tile);
        st.setFromX(.3);
        st.setFromY(.3);
        st.setToX(1.15);
        st.setToY(1.15);
        st.setInterpolator(Interpolator.SPLINE(0.25, 0.1, 0.25, 0.1));

        ScaleTransition st2 = new ScaleTransition(Duration.millis(150), tile);
        st2.setFromX(1.15);
        st2.setFromY(1.15);
        st2.setToX(1);
        st2.setToY(1);
        st2.setInterpolator(Interpolator.SPLINE(0.25, 0.1, 0.25, 0.1));

        SequentialTransition seqT = new SequentialTransition();
        seqT.getChildren().addAll(st, st2);
        seqT.play();
    }

}
