//Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
//        Example:
//
//        Input: s = 7, nums = [2,3,1,2,4,3]
//        Output: 2
//        Explanation: the subarray [4,3] has the minimal length under the problem constraint.
//        Follow up:
//        If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

public class P209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int sum = nums[0];
        int minLen = 0;

        while (true) {
            System.out.println("left is " + left + " right is " + right);
            System.out.println("sum is " + sum);
            System.out.println("minLen is " + minLen );
            if (sum >= s) {
                if (minLen == 0 || right - left + 1 < minLen) {
                    minLen = right - left + 1;
                }
                if (left == right) {
                    left++;
                    right++;
                    if (right >= nums.length) {
                        break;
                    }
                    sum = nums[left];
                } else {
                    sum -= nums[left];
                    left++;
                }
            } else {
                right++;
                if (right >= nums.length) {
                    break;
                }
                sum+=nums[right];
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        P209 p209 = new P209();
        System.out.println(p209.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
