//
//Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
//
//    Your algorithm's runtime complexity must be in the order of O(log n).
//
//    If the target is not found in the array, return [-1, -1].
//
//    Example 1:
//
//    Input: nums = [5,7,7,8,8,10], target = 8
//    Output: [3,4]
//    Example 2:
//
//    Input: nums = [5,7,7,8,8,10], target = 6
//    Output: [-1,-1]

import java.util.Arrays;

public class P34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        return new int[]{findLeftBound(nums, target), findRightBound(nums, target)};
    }

    public int findLeftBound(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        if (nums[0] == target) {
            return 0;
        }

        int left = 1;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (nums[mid - 1] != target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    public int findRightBound(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        if (nums[nums.length-1] == target) {
            return nums.length - 1;
        }

        int left = 0;
        int right = nums.length - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (nums[mid + 1] != target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        P34 p34 = new P34();
        System.out.println(Arrays.toString(p34.searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(p34.searchRange(new int[]{5,7,7,8,8,10}, 6)));
    }
}
