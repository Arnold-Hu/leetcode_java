//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
//    Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//
//    You may assume nums1 and nums2 cannot be both empty.
//
//    Example 1:
//
//    nums1 = [1, 3]
//    nums2 = [2]
//
//    The median is 2.0
//    Example 2:
//
//    nums1 = [1, 2]
//    nums2 = [3, 4]
//
//    The median is (2 + 3)/2 = 2.5

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

public class P4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return findMedian(nums2);
        }
        if (nums2.length == 0) {
            return findMedian(nums1);
        }

        if (nums1[nums1.length - 1] <= nums2[0]) {
            return findMedian(nums1, nums2);
        }

        if (nums2[nums2.length - 1] <= nums1[0]) {
            return findMedian(nums2, nums1);
        }


        boolean isEven = ((nums1.length + nums2.length) & 1) == 0;

        int indexSum = (nums1.length + nums2.length) / 2;

        boolean num1LargeThanNum2 = nums1.length > nums2.length;

        int[] movingArray;
        int[] negArray;

        if (num1LargeThanNum2) {
            movingArray = nums2;
            negArray = nums1;
        } else {
            movingArray = nums1;
            negArray = nums2;
        }

        int l = 0;
        int r = movingArray.length;

        int ret;
        while (true) {
            int index = (l + r) / 2;
            System.out.println(l + "," + r);
            int direction = direct(movingArray, negArray, index);
            if (direction == -1) {
                r = index;
            } else if (direction == 1) {
                l = index+1;
            } else {
                ret = index;
                break;
            }
        }

        int otherRet = indexSum - ret;

        if (!isEven) {
            if (ret == movingArray.length) {
                return negArray[otherRet];
            } else {
                return Math.min(negArray[otherRet], movingArray[ret]);
            }
        } else {
            if (ret == 0) {
                return (negArray[otherRet-1] + Math.min(movingArray[ret], negArray[otherRet])) / 2.0;
            } else if (ret == movingArray.length) {
                return (Math.max(movingArray[ret-1], negArray[otherRet-1]) + negArray[otherRet]) / 2.0;
            } else {
                int left = Math.max(movingArray[ret-1], negArray[otherRet-1]);
                int right = Math.min(movingArray[ret], negArray[otherRet]);
                return (left + right) / 2.0;
            }
        }

    }

    // -1 left 1 right 0 ok
    public int direct(int[] movingArray, int[] negArray, int index) {
        int indexSum = (movingArray.length + negArray.length) / 2;
        int otherIndex = indexSum - index;

        if (index == 0) {
            if (movingArray[index] >= negArray[otherIndex-1]) {
                return 0;
            } else {
                return 1;
            }
        }

        if (index == movingArray.length) {
            if (movingArray[index - 1] <= negArray[otherIndex]) {
                return 0;
            } else {
                return -1;
            }
        }

        if (movingArray[index - 1] > negArray[otherIndex]) {
            return -1;
        } else if (movingArray[index] < negArray[otherIndex - 1]) {
            return 1;
        } else {
            return 0;
        }
    }


    private static double findMedian(int[] nums) {
        if ((nums.length & 1) == 1) {
            return nums[nums.length/2];
        } else {
            return (nums[nums.length/2-1] + nums[nums.length/2]) / 2.0;
        }
    }

    private static double findMedian(int[] nums, int[] nums2) {
        boolean isOdd = ((nums.length + nums2.length) & 1) == 1;
        int index = (nums.length + nums2.length) / 2;
        if (isOdd) {
            if (index < nums.length) {
                return nums[index];
            } else {
                return nums2[index-nums.length];
            }
        } else {
            if (index == nums.length) {
                return (nums[index-1] + nums2[0]) / 2.0;
            } else if (index < nums.length) {
                return (nums[index-1] + nums[index]) / 2.0;
            } else {
                return (nums2[index-1-nums.length] + nums2[index-nums.length]) / 2.0;
            }
        }
    }

    public static void main(String[] args) {
        P4 p4 = new P4();
        System.out.println(p4.findMedianSortedArrays(new int[]{2}, new int[]{1,3,4}));
    }
}
