//Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
//
//    A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
//    Example:
//
//    X X X X
//    X O O X
//    X X O X
//    X O X X
//    After running your function, the board should be:
//
//    X X X X
//    X X X X
//    X X X X
//    X O X X
//    Explanation:
//
//    Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

import javafx.util.Pair;

import java.util.Stack;

public class P130 {
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        boolean[][] record = new boolean[board.length][board[0].length];
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        // pump edge o
        for (int i = 0; i<board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 'O') {
                    continue;
                }
                if (i == 0 || i == board.length - 1|| j == 0 || j == board[0].length -1) {
                    stack.add(new Pair<>(i, j));
                }
            }
        }


        while (!stack.empty()) {
            Pair<Integer, Integer> p = stack.pop();
            if (record[p.getKey()][p.getValue()]) {
                continue;
            } else {
                record[p.getKey()][p.getValue()] = true;
            }
            int x = p.getKey();
            int y = p.getValue();


            if ( x - 1 >=0 && x - 1 < board.length && board[x-1][y] == 'O') {
                stack.push(new Pair<>(x - 1, y));
            }
            if ( x + 1 >=0 && x + 1 < board.length && board[x+1][y] == 'O') {
                stack.push(new Pair<>(x+1, y));
            }
            if ( y - 1 >=0 && y - 1 < board[0].length && board[x][y-1] == 'O' ) {
                stack.push(new Pair<>(x, y-1));
            }
            if ( y + 1 >=0 && y + 1 < board[0].length && board[x][y+1] == 'O') {
                stack.push(new Pair<>(x, y+1));
            }
        }

        for (int i = 0; i<board.length;i++) {
            for (int j = 0; j < board[0].length;j++) {
                if (!record[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }


    }
}
