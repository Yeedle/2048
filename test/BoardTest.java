import javafx.scene.Node;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by Yeedle on 2/15/2016 5:04 PM.
 */
public class BoardTest {

    @Test
    public void testInitializeBoardProducesTwoTiles() throws Exception {
        Board b = new Board();
        b.initializeBoard();

        int numOfTilesFound = 0;
        Node node;
        Slot slot;
        for (int i = 0; i < b.getChildren().size(); i++){
            node = b.getChildren().get(i);

            if (node instanceof Slot && ((Slot)node).containsTile())
            {
                numOfTilesFound++;
            }

            assertThat(2, equalTo(numOfTilesFound));

        }

    }

    @Test
    public void testMovedUp() throws Exception {

    }

    @Test
    public void testMovedDown() throws Exception {

    }

    @Test
    public void testMovedLeft() throws Exception {

    }

    @Test
    public void testMovedRight() throws Exception {

    }

    @Test
    public void testMoved() throws Exception {

    }


}