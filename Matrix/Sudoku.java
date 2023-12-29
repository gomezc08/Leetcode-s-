/*
 * 36. Valid Sudoku
 * 
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */

// have hashset for each col, row.

import java.util.HashSet;

public class Sudoku {
    public boolean isValidSudoku(char[][] board) {
        // define our hashsets.
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] box = new HashSet[9]; 

        // initialize each hashset.
        for (int i = 0; i < 9; i++) {
            col[i] = new HashSet<Character>();
            row[i] = new HashSet<Character>();
            box[i] = new HashSet<Character>();
        }

        // define our loop.
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // case 1: empty space
                if (board[i][j] == '.') {
                    continue;
                }
                // case 2: invalid character
                else if (col[j].contains(board[i][j]) || row[i].contains(board[i][j]) || box[i / 3 * 3 + j / 3].contains(board[i][j])) {
                    return false;
                }
                col[j].add(board[i][j]);
                row[i].add(board[i][j]);
                box[i / 3 * 3 + j / 3].add(board[i][j]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(s.isValidSudoku(board));
    }
}