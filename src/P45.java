//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//    Each element in the array represents your maximum jump length at that position.
//
//    Your goal is to reach the last index in the minimum number of jumps.
//
//    Example:
//
//    Input: [2,3,1,1,4]
//    Output: 2
//    Explanation: The minimum number of jumps to reach the last index is 2.
//    Jump 1 step from index 0 to 1, then 3 steps to the last index.
//    Note:
//
//    You can assume that you can always reach the last index.

import java.util.Arrays;

public class P45 {
    public int jump(int[] nums) {

        if (nums.length <= 1) {
            return 0;
        }

        int jumpTime = 0;
        int headIndex = 0;
        int tailIndex = 0;
        int farest = 0;

        while (true) {
            jumpTime++;
            farest = 0;
            for (;tailIndex <= headIndex; tailIndex ++){
                if (tailIndex + nums[tailIndex] > farest) {
                    farest = tailIndex + nums[tailIndex];
                    if (farest >= nums.length - 1) {
                        return jumpTime;
                    }
                }
            }
            tailIndex = headIndex + 1;
            headIndex = farest;
        }
    }

    public static void main(String[] args) {
        P45 p45 = new P45();
        System.out.println(p45.jump(new int[]{2,3,1,1,4}));
    }
}
