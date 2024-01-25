import java.util.HashMap;

class NumberIslands {
    public int numIslands(char[][] grid) {
        HashMap<String, Integer> memo = new HashMap<>();
        int x = 0, y = 0;
        return numIslandsHelper(grid, x, y, 0);
    }

    public int numIslandsHelper(char[][] grid, int x, int y, int sum) {
        // base : we are on water or out of bounds.
        if(grid[x][y] == '0' || x > grid.length - 2 || y > grid[0].length - 2) {
            return sum;
        }

        // recursive case : we are on land; visit all neighbors.
        sum += 1;
        return Math.min(numIslandsHelper(grid, x+1, y, sum), numIslandsHelper(grid, x, y+1, sum));
    }
    public static void main(String[] args) {
        NumberIslands n = new NumberIslands();
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        
        System.out.println(n.numIslands(grid));
    }
}