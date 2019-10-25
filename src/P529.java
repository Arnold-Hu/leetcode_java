import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class P529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board.length <= 0 || board[0].length <= 0) {
            return board;
        }
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.add(new Pair<>(click[0], click[1]));

        while (!stack.empty()) {
            Pair<Integer, Integer> pop = stack.pop();
            List<Pair<Integer, Integer>> neibors = findAdjecent(board, pop);
            System.out.println(neibors);
            long bombCount = neibors.stream().filter(pair -> board[pair.getKey()][pair.getValue()] == 'M').count();
            if (bombCount > 0) {
                board[pop.getKey()][pop.getValue()] = (char)('0' + bombCount);
            } else {
                board[pop.getKey()][pop.getValue()] = 'B';
                stack.addAll(neibors.stream().filter(x -> board[x.getKey()][x.getValue()] == 'E').collect(Collectors.toList()));
            }
        }
        return board;
    }

    private List<Pair<Integer, Integer>> findAdjecent(char[][] board, Pair<Integer, Integer> click) {
        List<Pair<Integer, Integer>> res = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++ ) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (click.getKey() + i < 0 || click.getKey() + i >= board.length
                        || click.getValue() + j < 0 || click.getValue() + j >= board[0].length) {
                    continue;
                }
                Pair<Integer, Integer> dot = new Pair<>(click.getKey() + i, click.getValue() + j);
                res.add(dot);
            }
        }
        return res;
    }
}
