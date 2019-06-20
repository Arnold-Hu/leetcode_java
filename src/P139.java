//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//    Note:
//
//    The same word in the dictionary may be reused multiple times in the segmentation.
//    You may assume the dictionary does not contain duplicate words.
//    Example 1:
//
//    Input: s = "leetcode", wordDict = ["leet", "code"]
//    Output: true
//    Explanation: Return true because "leetcode" can be segmented as "leet code".
//    Example 2:
//
//    Input: s = "applepenapple", wordDict = ["apple", "pen"]
//    Output: true
//    Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//    Note that you are allowed to reuse a dictionary word.
//    Example 3:
//
//    Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//    Output: false

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> lens = new HashSet<>();
        Set<String> words = new HashSet<>();
        for (String string : wordDict) {
            lens.add(string.length());
            words.add(string);
        }

        Boolean[] result = new Boolean[s.length()];

        setResult(result, s, words, lens);



        return result[s.length()-1];

    }


    public void setResult(Boolean[] result, String s, Set<String> words, Set<Integer> lens) {
        if (result[s.length()-1] != null) {
            return;
        }
        for (int len : lens) {
            if (s.length() < len) {
                continue;
            }
            if (!words.contains(s.substring(0, len))) {
                continue;
            }
            if (s.length() == len) {
                result[s.length() - 1] = true;
                return;
            }

            setResult(result, s.substring(len), words, lens);

            if (result[s.length() - len - 1]) {
                result[s.length() - 1] = true;
                return;
            }

        }

        result[s.length()-1] = false;

    }
}
