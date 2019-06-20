//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
//    Example:
//
//    Input: n = 4, k = 2
//    Output:
//    [
//    [2,4],
//    [3,4],
//    [2,3],
//    [1,2],
//    [1,3],
//    [1,4],
//    ]

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> r = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        combine(r, stack, 1, n, k, k);
        return r;
    }

    public void combine(List<List<Integer>> res, Stack<Integer> temp, int start, int n, int k, int targetL) {
        if (temp.size() == targetL) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= n - k + 1; i ++) {
            temp.add(i);
            combine(res, temp, i+1, n, k - 1, targetL);
            temp.pop();
        }
    }
}
