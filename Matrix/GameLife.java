/*
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 */

public class GameLife {
    // treat board as new values.
    public void gameOfLife(int[][] board) {
        // define variables.
        int[][] old_values = board;
        // traverse through board.
        for(int rows = 0; rows < board.length; rows++) {
            for(int cols = 0; cols < board[0].length; cols++) {
                boolean needsChange = gameOfLifeHelper(board, rows, cols);
                // update board.
                if(needsChange) {
                    board[rows][cols] = (old_values[rows][cols] + 1) % 2;
                }
                else {
                    board[rows][cols] = old_values[rows][cols];
                }
            }
        }

        // TEST.

        /* 
        // old board.
        System.out.println("Old Board...");
        printBoard(old_values);
        // new board.
        System.out.println("New Board...");
        printBoard(board);
        */
    }

    public boolean gameOfLifeHelper(int[][] board, int r, int c) {
        // define counter variable.
        int neighbors_sum = 0;
        // check neighbors.
        for(int i = r-1; i < r+1; i++) {
            for(int j = c-1; j < c+1; c++) {
                // padding.
                if(!(i < 0 || j < 0 || i > board.length || j > board[0].length)) {
                    neighbors_sum += board[i][j];
                } 
            }
        }
        // DEAD.
        if(board[r][c] == 0) {
            // 3 live neighbors.
            if(neighbors_sum == 3) {
                return false;
            }
            else {
                return true;
            }
        }

        // ALIVE
        else {
            // fewer than 2.
            if(neighbors_sum < 2 || neighbors_sum > 3) {
                return true;
            }
            // 2 < neighboard_sum < 3.
            else {
                return false;
            }
        }
    }
        public void printBoard(int[][] board) {
            for(int rows = 0; rows < board.length; rows++) {
                for(int cols = 0; cols < board[0].length; cols++) {
                    System.out.print(board[rows][cols] + " ");
                }
            }
            System.out.println("");
        }

    public static void main(String[] args) {
        GameLife g = new GameLife();
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        g.gameOfLife(board);
    }
}
