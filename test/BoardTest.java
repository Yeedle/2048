import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by Yeedle on 2/15/2016 5:04 PM.
 */
public class BoardTest {

    @Test
    public void testInitializeBoard() throws Exception {

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

    @Test
    public void testCalculatePixelsBasedOn() throws Exception {
        TileAnimation ta = new TileAnimation();
        double pixels = ta.calculatePixelsBasedOn(2);
        double expected = 280;
        assertThat("", expected, equalTo(pixels));


    }
}