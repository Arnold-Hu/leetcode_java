/**
 * Created by hubingcheng on 2019/7/25.
 *
 */

//A peak element is an element that is greater than its neighbors.
//
//        Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
//
//        The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//
//        You may imagine that nums[-1] = nums[n] = -∞.
//
//        Example 1:
//
//        Input: nums = [1,2,3,1]
//        Output: 2
//        Explanation: 3 is a peak element and your function should return the index number 2.
//        Example 2:
//
//        Input: nums = [1,2,1,3,5,6,4]
//        Output: 1 or 5
//        Explanation: Your function can return either index number 1 where the peak element is 2,
//        or index number 5 where the peak element is 6.
//        Note:
//
//        Your solution should be in logarithmic complexity.
public class P162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return 0;
            } else {
                return 1;
            }
        }

        while (right - left > 1) {
            int mid = (left + right) / 2;
            System.out.println(left + ", " + mid + ", " + right);
            System.out.println("====");
            if (nums[mid - 1] < nums[mid] && nums[mid+1] < nums[mid]) {
                return mid;
            } else if (nums[mid - 1] < nums[mid] && nums[mid+1] > nums[mid]) {
                left = mid + 1;
            } else if (nums[mid - 1] > nums[mid] && nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }

        if (nums[right] > nums[left]) {
            return right;
        } else {
            return left;
        }





    }

    public static void main(String[] args) {
        P162 p162 = new P162();
        System.out.println(p162.findPeakElement(new  int[]{3,4,3,2,1}));
    }
}
