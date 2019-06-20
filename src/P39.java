//Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
//    The same repeated number may be chosen from candidates unlimited number of times.
//
//    Note:
//
//    All numbers (including target) will be positive integers.
//    The solution set must not contain duplicate combinations.
//    Example 1:
//
//    Input: candidates = [2,3,6,7], target = 7,
//    A solution set is:
//    [
//    [7],
//    [2,2,3]
//    ]
//    Example 2:
//
//    Input: candidates = [2,3,5], target = 8,
//    A solution set is:
//    [
//    [2,2,2,2],
//    [2,3,3],
//    [3,5]
//    ]

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (target == 0) {
            List<List<Integer>> l = new LinkedList<>();
            l.add(new LinkedList<>());
            return l;
        }

        if (candidates.length == 0) {
            return new LinkedList<>();
        }

        if (target < 0) {
            return new LinkedList<>();
        }

        List<List<Integer>> ret = new LinkedList<>();
        for (int i = 0; i * candidates[candidates.length - 1] <= target; i++ ) {
            List<List<Integer>> r = combinationSum(Arrays.copyOfRange(candidates, 0, candidates.length-1),
                target-i * candidates[candidates.length - 1]);
            List<Integer> l = new LinkedList<>();
            for (int j=0; j<i; j++) {
                l.add(candidates[candidates.length -1]);
            }
            r.forEach(x -> x.addAll(l));
            ret.addAll(r);

        }

        return ret;
    }

    public static void main(String[] args) {
        P39 p39 = new P39();
        System.out.println(p39.combinationSum(new int[]{2,3,5}, 8));
    }
}
