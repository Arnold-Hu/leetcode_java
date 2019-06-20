//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
//    Each number in candidates may only be used once in the combination.
//
//    Note:
//
//    All numbers (including target) will be positive integers.
//    The solution set must not contain duplicate combinations.
//    Example 1:
//
//    Input: candidates = [10,1,2,7,6,1,5], target = 8,
//    A solution set is:
//    [
//    [1, 7],
//    [1, 2, 5],
//    [2, 6],
//    [1, 1, 6]
//    ]
//    Example 2:
//
//    Input: candidates = [2,5,2,1,2], target = 5,
//    A solution set is:
//    [
//    [1,2,2],
//    [5]
//    ]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class P40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Map<Integer, Integer> coutMap = new HashMap<>();
        List<Integer> cands = new ArrayList<>(candidates.length);
        for (int cand : candidates) {
            if (coutMap.containsKey(cand)) {
                coutMap.put(cand, coutMap.get(cand) + 1);
            } else {
                cands.add(cand);
                coutMap.put(cand, 1);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();




        combinationSum2(res, temp, coutMap, cands, 0, 0, target);
        return res;
    }
//
//
    public void combinationSum2(List<List<Integer>> res, List<Integer> temp,
                                               Map<Integer, Integer> coutMap,
                                               List<Integer> cands,
                                               int sum,
                                               int start,
                                               int target) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (sum > target) {
            return;
        }

        if (start >= cands.size()) {
            return;
        }


        for  (int i=0; i<=coutMap.get(cands.get(start)); i++) {
            combinationSum2(res, temp, coutMap, cands, sum, start + 1, target);
            temp.add(cands.get(start));
            sum+=cands.get(start);
        }

        for  (int i=0; i<=coutMap.get(cands.get(start)); i++) {
            temp.remove(temp.size() -1);
            sum-=cands.get(start);
        }
    }

    public static void main(String[] args) {
        P40 p40 = new P40();
        System.out.println(p40.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(p40.combinationSum2(new int[]{2,2,2,2,5,2,1,2}, 7));
    }
}
