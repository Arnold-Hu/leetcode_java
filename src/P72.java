//Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
//
//    You have the following 3 operations permitted on a word:
//
//    Insert a character
//    Delete a character
//    Replace a character
//    Example 1:
//
//    Input: word1 = "horse", word2 = "ros"
//    Output: 3
//    Explanation:
//    horse -> rorse (replace 'h' with 'r')
//    rorse -> rose (remove 'r')
//    rose -> ros (remove 'e')
//    Example 2:
//
//    Input: word1 = "intention", word2 = "execution"
//    Output: 5
//    Explanation:
//    intention -> inention (remove 't')
//    inention -> enention (replace 'i' with 'e')
//    enention -> exention (replace 'n' with 'x')
//    exention -> exection (replace 'n' with 'c')
//    exection -> execution (insert 'u')

public class P72 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i< dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < Math.min(dp.length, dp[0].length); i++ ) {
            compute(word1, word2, dp, i, i);
            for ( int j = i + 1; j < dp.length ; j ++) {
                compute(word1, word2, dp, j, i);
            }
            for ( int j = i + 1; j < dp[0].length ; j ++) {
                compute(word1, word2, dp, i, j);
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];

    }


    public void compute(String word1, String word2, int[][] dp, int index1, int index2) {
        if (word1.charAt(index1 - 1) == word2.charAt(index2 - 1)) {
            dp[index1][index2] = dp[index1-1][index2-1];
        } else {
            dp[index1][index2] = 1 + Math.min(dp[index1-1][index2-1], Math.min(dp[index1-1][index2], dp[index1][index2-1]));
        }
    }
}
