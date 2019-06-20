//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//    Return the minimum cuts needed for a palindrome partitioning of s.
//
//    Example:
//
//    Input: "aab"
//    Output: 1
//    Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

import java.util.Arrays;

public class P132 {

    public int minCut(String s) {
        int[] minCut = new int[s.length()];
        Boolean[][] matrix = new Boolean[s.length()][s.length()];
        minCut[s.length()-1] = 0;
        for (int start = s.length() - 2; start >= 0; start--) {
            if (isP(matrix, s, start, s.length()-1)) {
                System.out.println("bong　"+ start );
                minCut[start] = 0;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int end = start; end < s.length() - 1; end++ ) {
                if (isP(matrix, s, start, end)) {
                    min = Math.min(min, minCut[end+1] + 1);
                }
            }
            minCut[start] = min;
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.toString(minCut));
        return minCut[0];
    }


    private boolean isP(Boolean[][] matrix, String s, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (matrix[left][right] != null) {
            return matrix[left][right];
        }

        boolean ret;

        if (s.charAt(left) != s.charAt(right)) {
            ret = false;
        } else {
            ret = isP(matrix, s, left + 1, right - 1);
        }

        matrix[left][right] = ret;
        return ret;


    }

    public static void main(String[] args) {
        P132 p132 = new P132();
        System.out.println(p132.minCut("aab"));
//        System.out.println(p132.isP(new Boolean[3][3], "aab", 1, 2));
    }
}
