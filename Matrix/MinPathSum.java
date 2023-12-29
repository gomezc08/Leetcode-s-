import java.util.HashMap;
import java.util.Map;

public class MinPathSum {
    private Map<String, Integer> memo = new HashMap<>();

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        return minPathSumHelper(grid, 0, 0, rows, cols);
    }

    private int minPathSumHelper(int[][] grid, int row, int col, int rows, int cols) {
        if (row == rows - 1 && col == cols - 1) {
            return grid[row][col];
        }

        String key = row + "-" + col;

        // Check if result is already memoized
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int rightSum = (col < cols - 1) ? minPathSumHelper(grid, row, col + 1, rows, cols) : Integer.MAX_VALUE;
        int downSum = (row < rows - 1) ? minPathSumHelper(grid, row + 1, col, rows, cols) : Integer.MAX_VALUE;

        int minPath = grid[row][col] + Math.min(rightSum, downSum);

        // Memoize the result
        memo.put(key, minPath);

        return minPath;
    }

    public static void main(String[] args) {
        MinPathSum m = new MinPathSum();
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        System.out.println(m.minPathSum(grid));
    }
}
