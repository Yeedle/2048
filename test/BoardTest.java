import javafx.application.Application;
import javafx.scene.Node;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by Yeedle on 2/15/2016 5:04 PM.
 */
public class BoardTest{

    @Before
    public void setUp(){

        //TODO set up javaFX initialization to overcome IlligalStateException
        //http://stackoverflow.com/questions/18429422/basic-junit-test-for-javafx-8
    }

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