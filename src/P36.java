//Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
//
//    Each row must contain the digits 1-9 without repetition.
//    Each column must contain the digits 1-9 without repetition.
//    Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

import java.util.Arrays;

public class P36 {
    public boolean isValidSudoku(char[][] board) {
        int[] map = new int[9];

        int i = 0;
        int j = 0;
        // row
////
        for (i = 0; i < 9; i++) {
            Arrays.fill(map, 0);
            for (j = 0; j < 9; j ++) {
                if (board[i][j] != '.') {
                    map[board[i][j] - 49] += 1;
                }
            }
            if (isNotValid(map)) {
                return false;
            }
        }

        for (i = 0; i < 9; i++) {
            Arrays.fill(map, 0);
            for (j = 0; j < 9; j ++) {
                if (board[j][i] != '.') {
                    map[board[j][i] - 49] += 1;
                }
            }
            if (isNotValid(map)) {
                return false;
            }
        }

        for (i = 0; i < 9; i++) {
            Arrays.fill(map, 0);
            for (j = 0; j < 9; j ++) {
                int x = (i % 3) * 3 + (j % 3);
                int y = (i / 3) * 3 + (j / 3);
                if (board[x][y] != '.') {
                    map[board[x][y] - 49] += 1;
                }
            }
            if (isNotValid(map)) {
                return false;
            }
        }

        return true;
    }

    private boolean isNotValid(int[] nums) {
        for (int i : nums) {
            if (i > 1) {
                return true;
            }
        }
        return false;
    }
}
