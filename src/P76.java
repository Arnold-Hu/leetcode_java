//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
//    Example:
//
//    Input: S = "ADOBECODEBANC", T = "ABC"
//    Output: "BANC"
//    Note:
//
//    If there is no such window in S that covers all characters in T, return the empty string "".
//    If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

import java.util.HashMap;
import java.util.Map;

public class P76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) {
            count.put(c, 0);
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        int head = 0;
        int tail = 0;


        int l = Integer.MAX_VALUE;
        String x = "";

        boolean flag = true;
        while (flag) {
            while (!satisfied(count, target)) {
                if (tail >= s.length()) {
                    flag = false;
                    break;
                }
                char ch = s.charAt(tail);
                if (count.containsKey(ch)){
                    count.put(ch, count.get(ch) + 1);
                }
                tail++;
            }

            if (!flag) {
                break;
            }

            while (satisfied(count, target)) {
                char ch = s.charAt(head);
                if (count.containsKey(ch)){
                    count.put(ch, count.get(ch) - 1);
                }
                head++;
            }


            if (tail - head < l) {
                l = tail - head;
                x = s.substring(head - 1, tail);
            }
        }


        return x;


    }

    private boolean satisfied(Map<Character, Integer> count, Map<Character, Integer> target) {
        return target.keySet().stream().allMatch(k -> count.getOrDefault(k, 0)  >= target.getOrDefault(k, 0));
    }

    public static void main(String[] args) {
        P76 p76 = new P76();
//        p76.minWindow("ODEBANC", "ABC");
        System.out.println(p76.minWindow("a", "aa"));
//        System.out.println(p76.minWindow("ODEBANC", "ABC"));

    }
}
