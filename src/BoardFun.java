import java.util.Random;

/**
 * Created by Modi on 2/19/2016.
 */
public class BoardFun {
    static int[][] board = new int[4][4];

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
        if(shiftBoard(board)){
            //generate a new tile
        }else{
            //check if game is over by finding (or not finding) 0s, and by looking for a possible merge
        }
        prntBoard();
    }
}