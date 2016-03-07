import java.util.Random;

/**
 * Model is an abstract representation of the 2048 board. There are no tiles in this
 * representation, just values in a 2d array. There's only one move available in this representation
 * and that is the move to the left. The rest of the moves are accomplished by rotating the board.
 * This should serve as the Model layer. There should be a Controller class which should communicate
 * between the GUI classes, and this class.
 * Created by Modi on 2/19/2016.
 */
public class Model {
    final static int ROWS = 4;
    final static int COLUMNS = 4;
    static int[][] board = new int[ROWS][COLUMNS];

    // constructor adds two random tiles to the board
    public Model(){
        for (int i = 0; i < 2; i++) {
            addNewLogicalTile();
        }
    }


    private void addNewLogicalTile() {
        int[][] emptyTiles = getEmptyTiles();
        if (emptyTiles.length > 0) {
            Random rand = new Random();
            int randNum = rand.nextInt(emptyTiles.length);

            int row = emptyTiles[randNum][0];
            int column = emptyTiles[randNum][1];
            board[row][column] = newValue();
        }
    }



    private int[][] getEmptyTiles() {
        int[][] emptyArray = new int[16][2];
        int i =0;
        for (int row = 0; row < ROWS; row++){
            for (int column = 0; column < COLUMNS; column++ ){
                if (board[row][column] == 0)
                    emptyArray[i] = new int[]{row, column};
                i++;
            }
        }
        int[][] emptyTiles = new int[i][2];
        for (int j = 0; j < i; j++) {
            emptyTiles[j] = emptyArray[j];
            }

        return emptyTiles;
    }


    private int newValue() {
        if(Math.random() < 0.9 ){
            return 2;
        }
        else{
            return 4;
        }
    }

    //************methods to handle moves left**************//

    public boolean moveLeft(Tile[][] logicBoard)
    {
        return shiftBoardLeft(logicBoard);
    }

    // call shiftRaw() for each row in the board
    static boolean shiftBoardLeft(Tile[][] board) {
        boolean boardShifted = false;
        for (Tile[] row : board) {
            if(mergeRowLeft(row)){
                boardShifted = true;
            }
        }
        return boardShifted;
    }

    // merge similar values
    static boolean mergeRowLeft(Tile[] row) {
        boolean merged = shiftZerosLeft(row);
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i].getValue() == row[i+1].getValue() && (row[i].getValue() != 0)) {
                row[i].setValue(row[i].getValue() + row[i+1].getValue());
                row[i+1].setTransition(row[i+1].getTransition() + 1);
                row[i+1].setValue(0);
                merged = true;
            }
            shiftZerosLeft(row);
        }
        return merged;
    }

    // shifts 0s to the opposite direction
    static boolean shiftZerosLeft(Tile[] row) {
        boolean shifted = false;
        for (int i = 0; i < row.length; i++) {
            if (row[i].getValue() == 0) {
                for (int j = i + 1; j < row.length; j++) {
                    if (row[j].getValue() != 0) {
                        Tile tempTile = row[i];
                        row[i] = row[j];
                        row[i].setTransition(row[i].getTransition() + Math.abs(j - i));
                        row[j] = tempTile;
                        break;
                    }
                }
                shifted = true;
            }
        }
        return shifted;
    }

    //************methods to handle moves down**************//

    public boolean moveDown(Tile[][] logicBoard)
    {
        return shiftBoardDown(logicBoard);
    }

    // call shiftRaw() for each row in the board
    static boolean shiftBoardDown(Tile[][] logicBoard) {
        boolean boardShifted = false;
        rotateLogicBoard(logicBoard);
        for (Tile[] row : logicBoard) {
            if(mergeRowDown(row)){
                boardShifted = true;
            }
        }
        rotateLogicBoard(logicBoard);
        rotateLogicBoard(logicBoard);
        rotateLogicBoard(logicBoard);
        return boardShifted;
    }

    // merge similar values
    static boolean mergeRowDown(Tile[] row) {
        boolean merged = shiftZerosDown(row);
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i].getValue() == row[i+1].getValue() && (row[i].getValue() != 0)) {
                row[i].setValue(row[i].getValue() + row[i+1].getValue());
                row[i+1].setTransition(row[i+1].getTransition() + 1);
                row[i+1].setValue(0);
                merged = true;
            }
            shiftZerosDown(row);
        }
        return merged;
    }

    // shifts 0s to the opposite direction
    static boolean shiftZerosDown(Tile[] row) {
        boolean shifted = false;
        for (int i = 0; i < row.length; i++) {
            if (row[i].getValue() == 0) {
                for (int j = i + 1; j < row.length; j++) {
                    if (row[j].getValue() != 0) {
                        Tile tempTile = row[i];
                        row[i] = row[j];
                        row[i].setTransition(row[i].getTransition() + Math.abs(j - i));
                        row[j] = tempTile;
                        break;
                    }
                }
                shifted = true;
            }
        }
        return shifted;
    }

    //************methods to handle moves right**************//

    public boolean moveRight(Tile[][] logicBoard)
    {
        return shiftBoardDown(logicBoard);
    }

    // call shiftRaw() for each row in the board
    static boolean shiftBoardRight(Tile[][] logicBoard) {
        boolean boardShifted = false;
        rotateLogicBoard(logicBoard);
        rotateLogicBoard(logicBoard);
        for (Tile[] row : logicBoard) {
            if(mergeRowRight(row)){
                boardShifted = true;
            }
        }
        rotateLogicBoard(logicBoard);
        rotateLogicBoard(logicBoard);
        return boardShifted;
    }

    // merge similar values
    static boolean mergeRowRight(Tile[] row) {
        boolean merged = shiftZerosRight(row);
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i].getValue() == row[i+1].getValue() && (row[i].getValue() != 0)) {
                row[i].setValue(row[i].getValue() + row[i+1].getValue());
                row[i+1].setTransition(row[i+1].getTransition() + 1);
                row[i+1].setValue(0);
                merged = true;
            }
            shiftZerosRight(row);
        }
        return merged;
    }

    // shifts 0s to the opposite direction
    static boolean shiftZerosRight(Tile[] row) {
        boolean shifted = false;
        for (int i = 0; i < row.length; i++) {
            if (row[i].getValue() == 0) {
                for (int j = i + 1; j < row.length; j++) {
                    if (row[j].getValue() != 0) {
                        Tile tempTile = row[i];
                        row[i] = row[j];
                        row[i].setTransition(row[i].getTransition() + Math.abs(j - i));
                        row[j] = tempTile;
                        break;
                    }
                }
                shifted = true;
            }
        }
        return shifted;
    }

    //************methods to handle moves up**************//

    public boolean moveUp(Tile[][] logicBoard)
    {
        return shiftBoardUp(logicBoard);
    }

    // call shiftRaw() for each row in the board
    static boolean shiftBoardUp(Tile[][] logicBoard) {
        boolean boardShifted = false;
        rotateLogicBoard(logicBoard);
        rotateLogicBoard(logicBoard);
        rotateLogicBoard(logicBoard);
        for (Tile[] row : logicBoard) {
            if(mergeRowUp(row)){
                boardShifted = true;
            }
        }
        rotateLogicBoard(logicBoard);
        return boardShifted;
    }

    // merge similar values
    static boolean mergeRowUp(Tile[] row) {
        boolean merged = shiftZerosUp(row);
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i].getValue() == row[i+1].getValue() && (row[i].getValue() != 0)) {
                row[i].setValue(row[i].getValue() + row[i+1].getValue());
                row[i+1].setTransition(row[i+1].getTransition() + 1);
                row[i+1].setValue(0);
                merged = true;
            }
            shiftZerosUp(row);
        }
        return merged;
    }

    // shifts 0s to the opposite direction
    static boolean shiftZerosUp(Tile[] row) {
        boolean shifted = false;
        for (int i = 0; i < row.length; i++) {
            if (row[i].getValue() == 0) {
                for (int j = i + 1; j < row.length; j++) {
                    if (row[j].getValue() != 0) {
                        Tile tempTile = row[i];
                        row[i] = row[j];
                        row[i].setTransition(row[i].getTransition() + Math.abs(j - i));
                        row[j] = tempTile;
                        break;
                    }
                }
                shifted = true;
            }
        }
        return shifted;
    }

    //**************************//

    //rotate array 90 degrees clockwise
    static void rotateLogicBoard(Tile[][] logicBoard){
        int i = board.length;
        int j = board[0].length;
        Tile[][] rotatedArray = new Tile[j][i];
        for (int r = 0; r < i; r++) {
            for (int c = 0; c < j; c++) {
                rotatedArray[c][i-1-r] = logicBoard[r][c];
            }
        }
        logicBoard = rotatedArray;
    }


    static void prntBoard() {
        System.out.println("");
        for (int[] row : board) {
            for (int j : row) {
                System.out.print("[" + j + "]  ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();

        // populate the board with random 2s and 4s for testing purposes
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (rand.nextBoolean()) {
                    board[i][j] = 2;
                } else {
                    board[i][j] = 4;
                }
            }
        }

        prntBoard();
    }
}