//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//    Example:
//
//    Input: [1,1,2]
//    Output:
//    [
//    [1,1,2],
//    [1,2,1],
//    [2,1,1]
//    ]

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> cout = new HashMap<>();
        for (int num : nums) {
            cout.put(num, cout.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = cout.keySet();
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        permuteUnique(res, temp, cout, set, nums.length);
        return res;
    }

    public void permuteUnique(List<List<Integer>> res, List<Integer> temp, Map<Integer, Integer> cout, Set<Integer> set, int len) {
        for (int num : set) {
            if (cout.getOrDefault(num, 0) > 0) {
                temp.add(num);
                if (temp.size() == len) {
                    res.add(new ArrayList<>(temp));
                } else {
                    cout.put(num, cout.getOrDefault(num, 0) - 1);
                    permuteUnique(res, temp, cout, set, len);
                    cout.put(num, cout.getOrDefault(num, 0) + 1);
                }
                temp.remove(temp.size() - 1);

            }
        }
    }

    public static void main(String[] args) {
        P47 p47 = new P47();
        System.out.println(p47.permuteUnique(new int[]{1,1,2}));
        System.out.println(p47.permuteUnique(new int[]{1}));
        System.out.println(p47.permuteUnique(new int[]{}));
    }
}
