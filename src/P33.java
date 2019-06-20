//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//    (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
//    You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//    You may assume no duplicate exists in the array.
//
//    Your algorithm's runtime complexity must be in the order of O(log n).
//
//    Example 1:
//
//    Input: nums = [4,5,6,7,0,1,2], target = 0
//    Output: 4
//    Example 2:
//
//    Input: nums = [4,5,6,7,0,1,2], target = 3
//    Output: -1

public class P33 {
    public int search(int[] nums, int target) {
        int joint = 0;
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        if (nums.length == 2) {
            if (nums[0] == target) {
                return 0;
            }
            if (nums[1] == target) {
                return 1;
            }

            return -1;
        }


        if (nums[0] < nums[nums.length -1]) {
            return bisearch(nums, 0, nums.length-1, target);
        }

        int jointIndex = findTheJoint(nums);

        if (target >= nums[0]) {
            return bisearch(nums, 0, jointIndex, target);
        } else {
            return bisearch(nums, jointIndex + 1, nums.length -1, target);
        }
    }

    private int bisearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if ( nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return -1;
    }

    private int findTheJoint(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid+1] < nums[mid]) {
                return mid;
            } else if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        P33 p33 = new P33();
        System.out.println(p33.search(new int[]{4,5,6,7,0,1,2}, 4));
        System.out.println(p33.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(p33.search(new int[]{5,1,3}, 0));
    }
}

