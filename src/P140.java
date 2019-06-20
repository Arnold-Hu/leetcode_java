//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
//
//    Note:
//
//    The same word in the dictionary may be reused multiple times in the segmentation.
//    You may assume the dictionary does not contain duplicate words.
//    Example 1:
//
//    Input:
//    s = "catsanddog"
//    wordDict = ["cat", "cats", "and", "sand", "dog"]
//    Output:
//    [
//    "cats and dog",
//    "cat sand dog"
//    ]
//    Example 2:
//
//    Input:
//    s = "pineapplepenapple"
//    wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//    Output:
//    [
//    "pine apple pen apple",
//    "pineapple pen apple",
//    "pine applepen apple"
//    ]
//    Explanation: Note that you are allowed to reuse a dictionary word.
//    Example 3:
//
//    Input:
//    s = "catsandog"
//    wordDict = ["cats", "dog", "sand", "and", "cat"]
//    Output:
//    []

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class P140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List[] result = new List[s.length()];
        Set<Integer> lens = new HashSet<>();
        Set<String> words = new HashSet<>();

        for (int i = 0; i < result.length; i++) {
            result[i] = new LinkedList<Pair<String, Integer>>();
        }
        for (String string : wordDict) {
            lens.add(string.length());
            words.add(string);
        }


        for (int i=s.length()-1; i >= 0; i--) {
            setResult(result, s, i, words, lens);
        }


        if (result[0].size() == 0) {
            return Collections.emptyList();
        }


        List<String> strings = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();


        buildRet(result, 0, stringBuilder, strings);

        return strings;

    }


    public void setResult(List<Pair<String, Integer>>[] result, String s, int start, Set<String> words, Set<Integer> ls) {
        for (int len : ls) {
            if (start + len > s.length()) {
                continue;
            }
            String w = s.substring(start, start + len);
            if (!words.contains(w)) {
                continue;
            }

            if (start + len == s.length()) {
                result[start].add(new Pair<>(w, -1));
                continue;
            }

            if (result[start+len].size() > 0) {
                result[start].add(new Pair<>(w, start + len));
            }
        }
    }


    public void buildRet(List<Pair<String, Integer>>[] r, int index, StringBuilder stringBuilder, List<String> ret) {
        int l = stringBuilder.length();
        for (Pair<String, Integer> pair : r[index]) {
            if (l == 0) {
                stringBuilder.append(pair.getKey());
            } else {
                stringBuilder.append(" ").append(pair.getKey());
            }
            if (pair.getValue() == -1) {
                ret.add(stringBuilder.toString());
            } else {
                buildRet(r, pair.getValue(), stringBuilder, ret);
            }
            stringBuilder.setLength(l);
        }
    }

    public static void main(String[] args) {
        P140 p140 = new P140();
        System.out.println(p140.wordBreak("aaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList(
            "a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }


}
