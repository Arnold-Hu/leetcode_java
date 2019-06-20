//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//
//    A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class P17 {
    private final static Map<Character, String> map = new HashMap<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits) || null == digits) {
            return new ArrayList<>();
        } else if (digits.length() == 1) {
            String x = map.get(digits.charAt(0));
            List<String> l = new ArrayList<>();
            for (char c : x.toCharArray()){
                l.add(String.valueOf(c));
            }
            return l;
        } else {
            List<String> l = letterCombinations(digits.substring(0,digits.length()-1));
            List<String> newL = new ArrayList<>(l.size() * 4);
            for (char c : map.get(digits.charAt(digits.length() - 1)).toCharArray()) {
                for (String s : l) {
                    newL.add(s + c);
                }
            }

            return newL;
        }
    }

    public static void main(String[] args) {
        P17 p17 = new P17();
        System.out.println(p17.letterCombinations("23"));
    }
}
