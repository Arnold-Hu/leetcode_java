//You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
//
//    Example 1:
//
//    Input:
//    s = "barfoothefoobarman",
//    words = ["foo","bar"]
//    Output: [0,9]
//    Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
//    The output order does not matter, returning [9,0] is fine too.
//    Example 2:
//
//    Input:
//    s = "wordgoodgoodgoodbestword",
//    words = ["word","good","best","word"]
//    Output: []

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P30 {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || "".equals(s)) {
            return Collections.emptyList();
        }

        if (words.length == 0) {
            return Collections.emptyList();
        }


        int l = words[0].length();
        int maxLength = s.length();
        List<Integer> ret = new LinkedList<>();

        Map<String, Integer> target = new HashMap<>();
        for (String word : words) {
            target.put(word, target.getOrDefault(word, 0) + 1);
        }

        for (int start = 0; start < l; start ++ ){
            Map<String, Integer> count = new HashMap<>();
            for (String word : words) {
                count.put(word, 0);
            }
            int head = start;
            int tail = start + l * words.length;
            if (tail > maxLength) {
                continue;
            }
            for (int x = 0; x < words.length; x++) {
                String t = s.substring(head + x * l, head + (x+1) * l);
                if (count.containsKey(t)) {
                    count.put(t, count.get(t) + 1);
                }
            }
            if (check(count, target)) {
                ret.add(head);
            }

            while (tail + l <= maxLength){
                inAndOut(count, s.substring(head, head + l), s.substring(tail, tail + l));
                head += l;
                tail += l;
                if (check(count, target)) {
                    ret.add(head);
                }
            }
        }
        return ret;
    }

    private boolean check(Map<String, Integer> count, Map<String, Integer> target) {
        return count.entrySet().stream().allMatch( entry -> target.get(entry.getKey()).equals(entry.getValue()));
    }

    private void inAndOut(Map<String, Integer> count, String out, String in) {
        if (count.containsKey(out)) {
            count.put(out, count.get(out) - 1);
        }
        if (count.containsKey(in)) {
            count.put(in, count.get(in) + 1);
        }
    }

    public static void main(String[] args) {
        P30 p30 = new P30();
        System.out.println(p30.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
        System.out.println(p30.findSubstring("wordgoodgoodgoodbestword", new String[]{"foo","bar"}));
        System.out.println(p30.findSubstring("ababaab", new String[]{"ab","ba","ba"}));
        System.out.println(p30.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }
}
