import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by Yeedle on 2/15/2016 5:06 PM.
 */
public class TileAnimationTest {

    @Test
    public void testMoveTile() throws Exception {

    }

    @Test
    public void testPlayAnimations() throws Exception {

    }

    @Test
    public void testCalculatePixelsBasedOn() throws Exception {
        TileAnimation ta = new TileAnimation();
        double pixels = ta.calculatePixelsBasedOn(2);
        double expected = 280;
        assertThat("", expected, equalTo(pixels));


    }
}