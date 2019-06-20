//Given an integer n, return all distinct solutions to the n-queens puzzle.
//
//    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
//    Example:
//
//    Input: 4
//    Output: [
//    [".Q..",  // Solution 1
//    "...Q",
//    "Q...",
//    "..Q."],
//
//    ["..Q.",  // Solution 2
//    "Q...",
//    "...Q",
//    ".Q.."]
//    ]
//    Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class P51 {
    public static void main(String[] args) {
        P51 p51 = new P51();
        System.out.println(p51.solveNQueens(1));
        System.out.println(p51.solveNQueens(0));
        System.out.println(p51.solveNQueens(4));
//        System.out.println(validpos(new LinkedList<Integer>(){{add(0);}}, 4));
    }


    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solveNQueens(ret, temp, n);
        return ret.stream().map(this::repr).collect(Collectors.toList());
    }

    private void solveNQueens(List<List<Integer>> ret, List<Integer> temp, int n) {
        if (temp.size() == n) {
            ret.add(new ArrayList<>(temp));
            return;
        }


        for (int i : validpos(temp, n)) {
            temp.add(i);
            solveNQueens(ret, temp, n);
            temp.remove(temp.size() - 1);
        }
    }

    private static List<Integer> validpos(List<Integer> ret, int n) {
        int[] flag = new int[n];
        int targetPos;
        int targetLine = ret.size();
        for (int i=0; i<=ret.size()-1; i++) {
            int pos = ret.get(i);
            targetPos = pos;
            if (targetPos >= 0 && targetPos < n) {
                flag[targetPos] = 1;
            }
            targetPos = targetLine - i + pos;
            if (targetPos >= 0 && targetPos < n) {
                flag[targetPos] = 1;
            }
            targetPos = pos + i - targetLine;
            if (targetPos >= 0 && targetPos < n) {
                flag[targetPos] = 1;
            }

        }

        List<Integer> r = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            if (flag[i] == 0) {
                r.add(i);
            }
        }


        return r;
    }
    private List<String> repr(List<Integer> ret) {
        List<String> r = new LinkedList<>();
        for (int i : ret) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<ret.size(); j++) {
                if (j == i) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            r.add(sb.toString());
        }
        return r;
    }


}
