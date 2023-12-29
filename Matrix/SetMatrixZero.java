/*
 * 73. Set Matrix Zeroes
 *
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 */
import java.util.*;

public class SetMatrixZero {

    // global variables.
    HashSet<Integer> ROWS = new HashSet<>();
    HashSet<Integer> COLS = new HashSet<>();

    public void setZeroes(int[][] matrix) {
        // define variables.
        int rows = matrix.length;
        int cols = matrix[0].length;

        // define iteration to check 0's.
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                // check if its 0.
                if(matrix[r][c] == 0) {
                    ROWS.add(r);
                    COLS.add(c);
                }
            }
        }

        // define interation for improving.
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {    
                // check if its column or row is 0.
                if(ROWS.contains(r) || COLS.contains(c)) {
                    matrix[r][c] = 0;
                }
            }
        }

        // TESTING.
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        SetMatrixZero s = new SetMatrixZero();
        int[][] matrix = {
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };
        s.setZeroes(matrix);
        int[][] matrix2 = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        s.setZeroes(matrix2);
    }
}
