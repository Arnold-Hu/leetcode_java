//Given a set of distinct integers, nums, return all possible subsets (the power set).
//
//    Note: The solution set must not contain duplicate subsets.
//
//    Example:
//
//    Input: nums = [1,2,3]
//    Output:
//    [
//    [3],
//    [1],
//    [2],
//    [1,2,3],
//    [1,3],
//    [2,3],
//    [1,2],
//    []
//    ]

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> r = new LinkedList<>();
        for (int k = 1; k <=  nums.length; k ++) {
            Stack<Integer> stack = new Stack<>();
            combine(r, stack, nums, 0, k);
        }
        r.add(new ArrayList<>());
        return r;
    }


    public void combine(List<List<Integer>> res, Stack<Integer> temp, int[] nums, int start, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= nums.length - k; i ++) {
            temp.add(nums[i]);
            combine(res, temp, nums, i + 1, k - 1);
            temp.pop();
        }
    }
}
