/*
 * 54. Spiral Matrix
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */

import java.util.*;

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        // variables.
        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1; // Subtract 1 from the length
        int bottom = matrix.length - 1;   // Subtract 1 from the length
        ArrayList<Integer> output = new ArrayList<Integer>();

        // define our while loop.
        while (left <= right && top <= bottom) {
            int l = left;
            while (l <= right) {
                output.add(matrix[top][l]);
                l++;
            }
            top++;
            
            int t = top;
            while (t <= bottom) {
                output.add(matrix[t][right]);
                t++;
            }
            right--;

            if (top <= bottom) { // check to prevent duplicate rows
                int r = right;
                while (r >= left) {
                    output.add(matrix[bottom][r]);
                    r--;
                }
                bottom--;
            }

            if (left <= right) { // check to prevent duplicate columns
                int b = bottom;
                while (b >= top) {
                    output.add(matrix[b][left]);
                    b--;
                }
                left++;
            }
        }
        return output;
    }
    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(s.spiralOrder(matrix));
    }
}
