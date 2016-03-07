import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Modi on 3/7/2016.
 */
public class ModelTest {

    Tile[][] testSet;

    @Before
    public void setUp() {
        testSet = new Tile[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                    testSet[i][j] = new Tile();
                    testSet[i][j].setValue(4);
                }
        }
    }


    @Test(timeout = 50)
    public void testMoveLeft(){
        Model.prntBoard(testSet);
        boolean shift = Model.moveLeft(testSet);
        Model.prntBoard(testSet);
        assertEquals("Expected value in tile 0,0 was 8", 8, testSet[0][0].getValue());
        assertEquals("Expected value in tile 0,2 was 0", 0, testSet[0][2].getValue());
        assertTrue("After a shift a true value wasn't returned", shift);
    }

    @Test(timeout = 50)
    public void testMoveDown(){
        Model.prntBoard(testSet);
        boolean shift = Model.moveDown(testSet);
        Model.prntBoard(testSet);
        assertEquals("Expected value in tile 0,0 was 0", 0, testSet[0][0].getValue());
        assertEquals("Expected value in tile 3,0 was 8", 8, testSet[3][0].getValue());
        assertTrue("After a shift a true value wasn't returned", shift);
    }

    @Test(timeout = 50)
    public void testMoveRight(){
        Model.prntBoard(testSet);
        boolean shift = Model.moveRight(testSet);
        Model.prntBoard(testSet);
        assertEquals("Expected value in tile 0,0 was 0", 0, testSet[0][0].getValue());
        assertEquals("Expected value in tile 0,3 was 0", 0, testSet[0][3].getValue());
        assertTrue("After a shift a true value wasn't returned", shift);
    }

    @Test(timeout = 50)
    public void testMoveUp(){
        Model.prntBoard(testSet);
        boolean shift = Model.moveUp(testSet);
        Model.prntBoard(testSet);
        assertEquals("Expected value in tile 0,0 was 8", 8, testSet[0][2].getValue());
        assertEquals("Expected value in tile 1,0 was 0", 0, testSet[1][0].getValue());
        assertTrue("After a shift a true value wasn't returned", shift);
    }

}