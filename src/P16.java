//
//Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//    Example:
//
//    Given array nums = [-1, 2, 1, -4], and target = 1.
//
//    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

import java.util.Arrays;


public class P16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int off = Integer.MAX_VALUE;
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i ++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int newSum = nums[i] + nums[l] + nums[r];
                int newOff = Math.abs(newSum - target);

                if (newOff < off) {
                    off = newOff;
                    sum = newSum;
                }
                if (newSum - target > 0) {
                    r -= 1;
                } else if (newSum - target < 0) {
                    l += 1;
                } else {
                    return target;
                }
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        P16 p16 = new P16();
        System.out.println(p16.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(p16.threeSumClosest(new int[]{0,0,0}, 1));
    }
}
