//Given an array of strings, group anagrams together.
//
//    Example:
//
//    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//    Output:
//    [
//    ["ate","eat","tea"],
//    ["nat","tan"],
//    ["bat"]
//    ]
//    Note:
//
//    All inputs will be in lowercase.
//    The order of your output does not matter.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ret = new HashMap<>();
        for (String s : strs) {
            String r = sort(s);
            ret.putIfAbsent(r, new LinkedList<>());
            ret.get(r).add(s);
        }

        return new ArrayList<>(ret.values());
    }

    private static String sort(String a) {
        if ("".equals(a)){
            return a;
        }
        char[] chars = a.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);

    }

    public static void main(String[] args) {
        P49 p49 = new P49();
        System.out.println(p49.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}