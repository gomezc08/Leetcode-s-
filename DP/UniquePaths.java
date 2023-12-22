/*
 * 62. Unique Paths

 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
*/

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
    private Map<String, Integer> memo = new HashMap<>();

    public int uniquePaths(int m, int n) {
        return uniquePathsHelper(m, n, 1, 1);
    }

    private int uniquePathsHelper(int m, int n, int i, int j) {
        // base case
        if (i == m && j == n) {
            return 1;
        } 
        else if (i > m || j > n) {
            return 0;
        }

        // check if the result is already memoized
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // recursive case
        int right = uniquePathsHelper(m, n, i + 1, j);
        int down = uniquePathsHelper(m, n, i, j + 1);

        // memoize the result
        int result = right + down;
        memo.put(key, result);

        return result;
    }
    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
        System.out.println(u.uniquePaths(3, 7));
    }
}
