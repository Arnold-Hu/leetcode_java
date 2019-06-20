//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
//
//    Example:
//
//    Input:
//    [
//    ["1","0","1","0","0"],
//    ["1","0","1","1","1"],
//    ["1","1","1","1","1"],
//    ["1","0","0","1","0"]
//    ]
//    Output: 6

import java.util.Arrays;

public class P85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int max = 0;
        int[][] hist = new int[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            for (int j= 0; j < matrix[0].length;j++) {
                if (i == 0) {
                    hist[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    hist[i][j] = matrix[i][j] == '1' ? 1 + hist[i-1][j] : 0;
                }
            }
            max = Math.max(max, largestRectangleArea(hist[i]));
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        if (heights.length == 1) {
            return heights[0];
        }
        int maxArea = 0;
        int[] lessFromLeft = new int[heights.length];
        int[] lessFromRight = new int[heights.length];

        lessFromLeft[0] = -1;
        lessFromRight[heights.length-1] = heights.length;


        for (int i=1; i<heights.length; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = heights.length -2; i >= 0; i--) {
            int p = i + 1;
            while (p <= heights.length - 1 && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
        for (int i = 0; i < heights.length; i ++) {
            maxArea = Math.max(maxArea, (lessFromRight[i] - lessFromLeft[i] - 1) * heights[i]);
        }
        return maxArea;

    }


}
