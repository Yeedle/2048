import java.util.Random;

/**
 * Created by Modi on 2/19/2016.
 */
public class LogicalBoard {
    final static int ROWS =4;
    final static int COLUMNS = 4;
    static int[][] board = new int[ROWS][COLUMNS];

    // constructor adds two random tiles to the board
    public LogicalBoard(){
        for (int i = 0; i < 2; i++) {
            addNewLogicalTile();
        }
    }


    private void addNewLogicalTile() {
        int[][] emptyTiles = getEmptyTiles();
        if (emptyTiles.length > 0) {
            Random rand = new Random();
            int randNum = rand.nextInt(emptyTiles.length);

            int row = emptyTiles[randNum][1];
            int column = emptyTiles[randNum][2];
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

    // call shiftRaw() for each row in the board
    static boolean shiftBoard(int[][] board) {
        boolean boardShifted = false;
        for (int[] row : board) {
            if(mergeRow(row)){
                boardShifted = true;
            }

        }
        return boardShifted;
    }

    // merge similar values
    static boolean mergeRow(int[] row) {
        boolean merged = shiftZeros(row);
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] == row[i + 1] && (row[i] != 0)) {
                row[i] += row[i + 1];
                row[i + 1] = 0;
                merged = true;
            }
            shiftZeros(row);
        }
        return merged;
    }

    // shifts 0s to the opposite direction
    static boolean shiftZeros(int[] row) {
        boolean shifted = false;
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 0) {
                for (int j = i + 1; j < row.length; j++) {
                    if (row[j] != 0) {
                        row[i] = row[j];
                        row[j] = 0;
                        break;
                    }
                }
                shifted = true;
            }
        }
        return shifted;
    }

    //rotate array 90 degrees clockwise
    static void rotateBoard(){
        int i = board.length;
        int j = board[0].length;
        int[][] rotatedArray = new int[j][i];
        for (int r = 0; r < i; r++) {
            for (int c = 0; c < j; c++) {
                rotatedArray[c][i-1-r] = board[r][c];
            }
        }
        board = rotatedArray;
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
        rotateBoard();
        rotateBoard();


        if(shiftBoard(board)){
            //generate a new tile
        }else{
            //check if game is over by finding (or not finding) 0s, and by looking for a possible merge
        }
        rotateBoard();
        rotateBoard();
        prntBoard();
    }
}