//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//
//    The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
//
//    Example:
//
//    Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//    Output: 6

import java.util.Arrays;

public class P42 {
    public int trap(int[] height) {
        if (height.length <= 2){
            return 0;
        }

        int[] leftMostHeight = new int[height.length];
        int[] rightMostHeight = new int[height.length];
        leftMostHeight[0] = -1;
        rightMostHeight[height.length-1] = -1;
        for (int i = 1; i<height.length-1;i++) {
            leftMostHeight[i] = Math.max(height[i-1], leftMostHeight[i-1]);
            rightMostHeight[height.length-1-i] = Math.max(height[height.length-i], rightMostHeight[height.length-i]);
        }
        int sum = 0;
        for (int i = 1; i<height.length-1;i++) {
            int barirer = Math.min(leftMostHeight[i], rightMostHeight[i]);
            if (height[i] < barirer) {
                sum += barirer - height[i];
            }
        }
        System.out.println(Arrays.toString(leftMostHeight));
        System.out.println(Arrays.toString(rightMostHeight));

        return sum;

    }

    public static void main(String[] args) {
        P42 p42 = new P42();
//        System.out.println(p42.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(p42.trap(new int[]{5,4,1,2}));
    }
}
