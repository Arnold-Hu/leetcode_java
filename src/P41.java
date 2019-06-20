//Given an unsorted integer array, find the smallest missing positive integer.
//
//    Example 1:
//
//    Input: [1,2,0]
//    Output: 3
//    Example 2:
//
//    Input: [3,4,-1,1]
//    Output: 2
//    Example 3:
//
//    Input: [7,8,9,11,12]
//    Output: 1
//    Note:
//
//    Your algorithm should run in O(n) time and uses constant extra space.

import java.util.Arrays;

public class P41 {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }


        for (int i = 0; i<nums.length; i++) {
            if (i+1 == nums[i]) {
                continue;
            }

            if (nums[i] > nums.length) {
                continue;
            }

            if (nums[i] <= 0) {
                continue;
            }

            int num = nums[i];
            nums[i] = -1;
            int temp;

            while (true) {
                temp = nums[num-1];
                nums[num - 1] = num;
                num = temp;

                if (num > nums.length) {
                    break;
                }

                if (num <= 0) {
                    break;
                }
                if (num == nums[num-1]) {
                    break;
                }
            }

        }

        int ret = nums.length + 1;
        for (int i =0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        P41 p41 = new P41();
        System.out.println(p41.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(p41.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(p41.firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(p41.firstMissingPositive(new int[]{1,1}));
    }

}
