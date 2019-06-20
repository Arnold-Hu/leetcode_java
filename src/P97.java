//Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
//    Example 1:
//
//    Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//    Output: true
//    Example 2:
//
//    Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//    Output: false

public class P97 {
    // recursive
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int[][] matrix = new int[s1.length()+1][s2.length()+1];
        return isInterleave(matrix, s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), 0);
    }

    public boolean isInterleave(int[][] matrix, char[] s1, int index1, char[] s2, int index2, char[] s3, int index3) {
        if (matrix[index1][index2] == 1) {
            return true;
        } else if (matrix[index1][index2] == -1) {
            return false;
        }

        boolean ret = false;
        if (index3 == s3.length) {
            ret =  true;
        } else if (index1 < s1.length && s3[index3] == s1[index1] && isInterleave(matrix, s1, index1 + 1, s2, index2, s3, index3 + 1)) {
            ret = true;
        } else if (index2 < s2.length && s3[index3] == s2[index2] && isInterleave(matrix, s1, index1, s2, index2+1, s3, index3 + 1)) {
            ret =  true;
        }

        matrix[index1][index2] = ret ? 1 : -1;

        return ret;

    }
}
