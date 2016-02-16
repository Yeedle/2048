import com.sun.istack.internal.NotNull;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yeedle on 2/15/2016 5:03 PM.
 */
public class AbstractTileTest {
    AbstractTile at = new AbstractTile(){};

    @Test
    public void testHasRectangle() throws Exception {

        assertNotNull(at.square);

    }


}