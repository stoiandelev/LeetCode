package Problems._2_Medium;

import java.util.HashSet;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells
 * need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */

public class _15_ValidSudoku_36 {

    public static void main(String[] args) {

        char[][] board = {
                {'5' , '3' , '.' , '.' , '7' , '.' , '.' , '.' , '.'}
                , {'5' , '.' , '.' , '1' , '9' , '5' , '.' , '.' , '.'}
                , {'.' , '9' , '8' , '.' , '.' , '.' , '.' , '6' , '.'}
                , {'8' , '.' , '.' , '.' , '6' , '.' , '.' , '.' , '3'}
                , {'4' , '.' , '.' , '8' , '.' , '3' , '.' , '.' , '1'}
                , {'7' , '.' , '.' , '.' , '2' , '.' , '.' , '.' , '6'}
                , {'.' , '6' , '.' , '.' , '.' , '.' , '2' , '8' , '.'}
                , {'.' , '.' , '.' , '4' , '1' , '9' , '.' , '.' , '5'}
                , {'.' , '.' , '.' , '.' , '8' , '.' , '.' , '7' , '9'}
        };

        System.out.println(isValidSudoku(board));

    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentValue = board[i][j];
                if (currentValue != '.') {
                    if (!seen.add(currentValue + " found in row " + i) ||
                       (!seen.add(currentValue + " found in column " + j) ||
                       (!seen.add(currentValue + " found in subBox " + i / 3 + "-" + j / 3))))
                       return false;
                }
            }
        }
        return true;
    }

}
