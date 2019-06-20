//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//    (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
//
//    You are given a target value to search. If found in the array return true, otherwise return false.
//
//    Example 1:
//
//    Input: nums = [2,5,6,0,0,1,2], target = 0
//    Output: true
//    Example 2:
//
//    Input: nums = [2,5,6,0,0,1,2], target = 3
//    Output: false
//    Follow up:
//
//    This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
//    Would this affect the run-time complexity? How and why?

import java.util.Arrays;

public class P81 {
    public boolean search(int[] nums, int target) {


        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return nums[0] == target;
        }
        if (target == nums[0]) {
            return true;
        }

        int right = nums.length - 1;

        if (nums[0] == nums[nums.length-1]) {
            while (nums[right] == nums[0]) {
                right--;
                if (right < 0) {
                    return false;
                }
            }
        }
        nums = Arrays.copyOf(nums, right+1);

        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return nums[0] == target;
        }


        int firstLess = findTheFirstLessThanStart(nums, 1, right);
        if (target > nums[0]) {
            return biSearch(nums, 0, firstLess - 1, target);
        } else {
            return biSearch(nums, firstLess, nums.length-1, target);
        }


    }

    public boolean biSearch(int[] nums, int left, int right, int target) {
        while (right >= left) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public int findTheFirstLessThanStart(int[] num, int left, int right) {
        while (right >= left) {
            int mid = (right + left) / 2;
            if (num[mid] >= num[0]) {
                left = mid + 1;
            } else if (num[mid] >= num[mid-1]){
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return num.length;
    }

    public static void main(String[] args) {
        P81 p81 = new P81();
        System.out.println(p81.search(new int[]{1, 3, 1, 1, 1}, 3));
    }


}
