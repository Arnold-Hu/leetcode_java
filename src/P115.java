//Given a string S and a string T, count the number of distinct subsequences of S which equals T.
//
//    A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
//    Example 1:
//
//    Input: S = "rabbbit", T = "rabbit"
//    Output: 3
//    Explanation:
//
//    As shown below, there are 3 ways you can generate "rabbit" from S.
//    (The caret symbol ^ means the chosen letters)
//
//    rabbbit
//    ^^^^ ^^
//    rabbbit
//    ^^ ^^^^
//    rabbbit
//    ^^^ ^^^
//    Example 2:
//
//    Input: S = "babgbag", T = "bag"
//    Output: 5
//    Explanation:
//
//    As shown below, there are 5 ways you can generate "bag" from S.
//    (The caret symbol ^ means the chosen letters)
//
//    babgbag
//    ^^ ^
//    babgbag
//    ^^    ^
//    babgbag
//    ^    ^^
//    babgbag
//    ^  ^^
//    babgbag
//    ^^^



import java.util.Arrays;

public class P115 {
    public int numDistinct(String s, String t) {
        int[][] table = new int[s.length()][t.length()];
        for (int[] l : table) {
            Arrays.fill(l, -1);
        }


        int ret = numDistinct(table, s.toCharArray(), 0, t.toCharArray(), 0);
        System.out.println(Arrays.deepToString(table));
        return ret;
    }

    public int numDistinct(int[][] table, char[] s, int index1, char[] t, int index2) {

//        if (index1 == s.length && index2 == t.length) {
//            return 1;
//        }

        if (index2 >= t.length) {
            return 1;
        }

        if (t.length - index2 > s.length - index1) {
            return 0;
        }


        if (table[index1][index2] >= 0) {
            return table[index1][index2];
        }
        int ret = 0;

        if (index1 == s.length - 1) {
            if (s[index1] == t[index2]) {
                ret = 1;
            }
        } else if (s[index1] == t[index2]) {
            ret =  numDistinct(table, s, index1 + 1, t, index2 + 1) + numDistinct(table, s, index1 +1, t, index2);
        } else {
            ret = numDistinct(table, s, index1 + 1, t, index2);
        }

        table[index1][index2] = ret;
        return ret;

    }

    public static void main(String[] args) {
        P115 p115 = new P115();
        System.out.println(p115.numDistinct("babgbag","bag"));
    }
}
