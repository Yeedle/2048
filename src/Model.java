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


    static boolean moveLeft(Tile[][] logicBoard) {
        prntBoard(logicBoard);
        boolean shifted = shiftBoard(logicBoard);
        prntBoard(logicBoard);
        return shifted;
    }

    static boolean moveDown(Tile[][] logicBoard)
    {
        boolean shifted;
        logicBoard = rotateLogicBoard(logicBoard);
        shifted = shiftBoard(logicBoard);
        logicBoard = rotateLogicBoard(logicBoard);
        logicBoard = rotateLogicBoard(logicBoard);
        logicBoard = rotateLogicBoard(logicBoard);
        return shifted;
    }

    static boolean moveRight(Tile[][] logicBoard)
    {
        boolean shifted;
        logicBoard = rotateLogicBoard(logicBoard);
        logicBoard = rotateLogicBoard(logicBoard);
        shifted = shiftBoard(logicBoard);
        logicBoard = rotateLogicBoard(logicBoard);
        logicBoard = rotateLogicBoard(logicBoard);
        return shifted;
    }

    static boolean moveUp(Tile[][] logicBoard)
    {
        boolean shifted;
        logicBoard = rotateLogicBoard(logicBoard);
        logicBoard = rotateLogicBoard(logicBoard);
        logicBoard = rotateLogicBoard(logicBoard);
        shifted = shiftBoard(logicBoard);
        logicBoard = rotateLogicBoard(logicBoard);
        return shifted;
    }



    // call shiftRaw() for each row in the board
    static boolean shiftBoard(Tile[][] board) {
        boolean boardShifted = false;
        for (Tile[] row : board) {
            if(mergeRow(row)){
                boardShifted = true;
            }
        }
        return boardShifted;
    }

    // merge similar values and shift to the respective wall
    static boolean mergeRow(Tile[] row) {
        boolean merged = false;
        int targetPosition = -1, stop = 0;
        for (int i = 1; i < row.length; i++) {
            if (row[i].getValue() != 0) {
                for (int j = i - 1; j >= stop; j--) {
                    if (row[j].getValue() == 0) {
                        if (j == 0 || j == stop) {
                            targetPosition = j;
                            stop = j;
                            break;
                        }else {
                            continue;
                        }
                    } else {
                        if (row[j].getValue() == row[i].getValue()) {
                            targetPosition = j;
                            stop = j+1;
                            break;
                        } else {
                            targetPosition = j + 1;
                            stop = targetPosition;
                            break;
                        }
                    }
                }
                if (targetPosition != i && targetPosition != -1) {
                    row[targetPosition].setValue(row[i].getValue() + row[targetPosition].getValue());
                    row[i].setTransition(row[i].getTransition() + Math.abs(targetPosition - i));
                    row[i].setValue(0);
                    targetPosition = -1;
                    merged = true;
                }
            }
        }
        return merged;
    }

    //************methods to handle moves down**************//

    /*static boolean moveDown(Tile[][] logicBoard)
    {
        return shiftBoardDown(logicBoard);
    }

    // call shiftRaw() for each row in the board
    static boolean shiftBoardDown(Tile[][] logicBoard) {
        boolean boardShifted = false;
        logicBoard = rotateLogicBoard(logicBoard);
        for (Tile[] row : logicBoard) {
            if(mergeRowDown(row)){
                boardShifted = true;
            }
        }
        logicBoard = rotateLogicBoard(logicBoard);
        logicBoard = rotateLogicBoard(logicBoard);
        logicBoard = rotateLogicBoard(logicBoard);
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
    }*/

    //************methods to handle moves right**************//

   /* static  boolean moveRight(Tile[][] logicBoard)
    {
        return shiftBoardDown(logicBoard);
    }

    // call shiftRaw() for each row in the board
    static boolean shiftBoardRight(Tile[][] logicBoard) {
        boolean boardShifted = false;
        logicBoard = rotateLogicBoard(logicBoard);
        logicBoard = rotateLogicBoard(logicBoard);
        for (Tile[] row : logicBoard) {
            if(mergeRowRight(row)){
                boardShifted = true;
            }
        }
        logicBoard = rotateLogicBoard(logicBoard);
        logicBoard = rotateLogicBoard(logicBoard);
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

    /*//************methods to handle moves up**************//*/

    static boolean moveUp(Tile[][] logicBoard)
    {
        return shiftBoardUp(logicBoard);
    }

    // call shiftRaw() for each row in the board
    static boolean shiftBoardUp(Tile[][] logicBoard) {
        boolean boardShifted = false;
        logicBoard = rotateLogicBoard(logicBoard);
        logicBoard = rotateLogicBoard(logicBoard);
        logicBoard = rotateLogicBoard(logicBoard);
        for (Tile[] row : logicBoard) {
            if(mergeRowUp(row)){
                boardShifted = true;
            }
        }
        logicBoard = rotateLogicBoard(logicBoard);
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

    /*//**************************//*/
*/
    //rotate array 90 degrees clockwise
    static Tile[][] rotateLogicBoard(Tile[][] logicBoard){
        int i = board.length;
        int j = board[0].length;
        Tile[][] rotatedArray = new Tile[j][i];
        for (int r = 0; r < i; r++) {
            for (int c = 0; c < j; c++) {
                rotatedArray[c][i-1-r] = logicBoard[r][c];
            }
        }
        return rotatedArray;
    }


    static void prntBoard(Tile[][] prntboard) {
        System.out.println("");
        for (Tile[] row : prntboard) {
            for (Tile j : row) {
                System.out.print("[" + j.getValue() + "]  " + j.getTransition()+ " | ");
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
/*
        // populate the board with random 2s and 4s for testing purposes
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (rand.nextDouble() < .2) {
                    board[i][j] = new Tile();
                    board[i][j].setValue(0);
                }
                else if(rand.nextDouble() < .4){
                    board[i][j] = new Tile();
                    board[i][j].setValue(4);
                }
                else if (rand.nextDouble() < 1){
                    board[i][j] = new Tile();
                    board[i][j].setValue(2);

                }
            }
        }


        prntBoard(board);
        moveLeft(board);

        prntBoard(board);*/

    }
}