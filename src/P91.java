//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//    'A' -> 1
//    'B' -> 2
//    ...
//    'Z' -> 26
//    Given a non-empty string containing only digits, determine the total number of ways to decode it.
//
//    Example 1:
//
//    Input: "12"
//    Output: 2
//    Explanation: It could be decoded as "AB" (1 2) or "L" (12).
//    Example 2:
//
//    Input: "226"
//    Output: 3
//    Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

public class P91 {
    public int numDecodings(String s) {
        return numDecodings(s.toCharArray());
    }

    public int numDecodings(char[] s) {
        int[] solution = new int[s.length + 1];
        if (s.length <= 0) {
            return 0;
        }
        if (s.length == 1) {
            return is1DigitOk(s, 0) ? 1 : 0;
        }

        solution[s.length] = 1;
        solution[s.length - 1] = is1DigitOk(s, s.length - 1) ? 1 : 0;

        for (int index = s.length - 2; index >= 0; index--) {
            if (is1DigitOk(s, index)) {
                solution[index] += solution[index+1];
            }
            if (is2DigitOk(s, index)) {
                solution[index] += solution[index+2];
            }
        }

        return solution[0];
    }


    public static boolean is2DigitOk(char[] s, int start) {
        if (s[start] == '1') {
            return true;
        } else if (s[start] == '2') {
            return s[start+1] >= '0' && s[start+1] <= '6';
        } else {
            return false;
        }
    }

    public static boolean is1DigitOk(char[] s, int start) {
        return s[start] >= '1' && s[start] <= '9';
    }




}
