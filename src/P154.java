//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//    (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
//
//    Find the minimum element.
//
//    The array may contain duplicates.
//
//    Example 1:
//
//    Input: [1,3,5]
//    Output: 1
//    Example 2:
//
//    Input: [2,2,2,0,1]
//    Output: 0
//    Note:
//
//    This is a follow up problem to Find Minimum in Rotated Sorted Array.
//    Would allow duplicates affect the run-time complexity? How and why?

public class P154 {
    public int findMin(int[] nums) {
        int left = 0;
        for (int i = 0; i<nums.length - 1; i++) {
            if (nums[i] != nums[i+1]) {
                left = i;
                break;
            }
        }

        int min = nums[left];




        int right = nums.length - 1;


        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("left " + left + " right " + right + " mid " + nums[mid] + " min " + min);
            if (nums[mid] > min) {
                left = mid + 1;
            } else {
                right = mid - 1;
                min = nums[mid];
            }

        }

        return min;

    }

    public static void main(String[] args) {
        P154 p154 = new P154();
        System.out.println(p154.findMin(new  int[] {4,1}));
    }
}
