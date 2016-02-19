import java.util.Random;

/**
 * Created by Modi on 2/19/2016.
 */
public class BoardFun {
    static int[][] board = new int[4][4];

    // call shiftRaw() for each row in the board
    static void shiftBoard(int[][] board) {
        for (int[] row : board) {
            mergeRow(row);
        }
    }

    // merge similar values
    static void mergeRow(int[] row) {
        shiftZeros(row);
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] == row[i + 1] && (row[i] != 0)) {
                row[i] += row[i + 1];
                row[i + 1] = 0;
            }
            shiftZeros(row);
        }
    }

    // shifts 0s to the opposite direction
    static void shiftZeros(int[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 0) {
                for (int j = i + 1; j < row.length; j++) {
                    if (row[j] != 0) {
                        row[i] = row[j];
                        row[j] = 0;
                        break;
                    }
                }
            }
        }
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
        shiftBoard(board);
        prntBoard();
    }
}