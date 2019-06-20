//Given a 2D board and a word, find if the word exists in the grid.
//
//    The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//    Example:
//
//    board =
//    [
//    ['A','B','C','E'],
//    ['S','F','C','S'],
//    ['A','D','E','E']
//    ]
//
//    Given word = "ABCCED", return true.
//    Given word = "SEE", return true.
//    Given word = "ABCB", return false.

import java.util.Stack;

public class P79 {
    public boolean exist(char[][] board, String word) {
        int[][] used = new int[board.length][board[0].length];
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j++) {
                if (go(board, w, used, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }


    public boolean go(char[][] board, char[] word, int[][] used, int row, int col, int l) {
        if (row >= board.length || row < 0) {
            return false;
        }

        if (col >= board[0].length || col < 0) {
            return false;
        }

        if (used[row][col] > 0) {
            return false;
        }

        if (word[l] != board[row][col]) {
            return false;
        }

        used[row][col] = 1;
        l++;


        boolean flag = false;
        if (l == word.length) {
            flag = true;
        } else if (go(board, word, used, row+1, col, l)) {
            flag = true;
        } else if (go(board, word, used, row-1, col, l)) {
            flag = true;
        } else if (go(board, word, used, row, col+1, l)) {
            flag = true;
        }else if (go(board, word, used, row, col-1, l)) {
            flag = true;
        }

        used[row][col] = 0;
        return flag;
    }
}
