//Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
//
//    '?' Matches any single character.
//    '*' Matches any sequence of characters (including the empty sequence).
//    The matching should cover the entire input string (not partial).
//
//    Note:
//
//    s could be empty and contains only lowercase letters a-z.
//    p could be empty and contains only lowercase letters a-z, and characters like ? or *.
//    Example 1:
//
//    Input:
//    s = "aa"
//    p = "a"
//    Output: false
//    Explanation: "a" does not match the entire string "aa".
//    Example 2:
//
//    Input:
//    s = "aa"
//    p = "*"
//    Output: true
//    Explanation: '*' matches any sequence.
//    Example 3:
//
//    Input:
//    s = "cb"
//    p = "?a"
//    Output: false
//    Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
//    Example 4:
//
//    Input:
//    s = "adceb"
//    p = "*a*b"
//    Output: true
//    Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
//    Example 5:
//
//    Input:
//    s = "acdcb"
//    p = "a*c?b"
//    Output: false

import java.util.Arrays;

public class P44 {
    public static void main(String[] args) {
        P44 p44 = new P44();

        System.out.println(p44.isMatch("aa", "a"));
        System.out.println(p44.isMatch("a", "aa"));
        System.out.println(p44.isMatch("aa", "*"));
        System.out.println(p44.isMatch("cb", "?a"));
        System.out.println(p44.isMatch("adceb", "*a*b"));
        System.out.println(p44.isMatch("acdcb", "a*c?b"));
        System.out.println(p44.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
//        System.out.println(Arrays.toString("*a*".split("\\*+")));


    }

//
//    public boolean isMatch(String s, String p) {
//        StringBuilder sb = new StringBuilder();
//        for (char c : p.toCharArray()) {
//            if (sb.length() >= 1 && sb.charAt(sb.length() - 1) == '*' && c == '*') {
//                continue;
//            }
//            sb.append(c);
//        }
//
//        p = sb.toString();
//        return match(s, p);
//    }
//
//
//
//    public boolean match(String s, String p) {
//
//        if (s.length() == 0) {
//            if ("".equals(p)) {
//                return true;
//            }
//
//            for (char c : p.toCharArray()) {
//                if (c != '*') {
//                    return false;
//                }
//            }
//
//            return true;
//
//        }
//
//        if (p.length() == 0) {
//            return false;
//        }
//        if (p.length() == 1) {
//            if ("?".equals(p)) {
//                return s.length() == 1;
//            } else if ("*".equals(p)) {
//                return true;
//            } else {
//                return s.equals(p);
//            }
//        }
//
//        if (p.charAt(0) == '?') {
//            return isMatch(s.substring(1), p.substring(1));
//        } else if (p.charAt(0) == '*') {
//            for (int i = 0; i < s.length(); i++) {
//                if (isMatch(s.substring(i), p.substring(1))) {
//                    return true;
//                }
//            }
//
//            return false;
//        } else {
//            if (s.charAt(0) != p.charAt(0)) {
//                return false;
//            }
//
//            return isMatch(s.substring(1), p.substring(1));
//        }
//
//
//
//
//    }


    public boolean isMatch(String s, String p) {
        if (p.equals("")) {
            return s.equals(p);
        }


        StringBuilder sb = new StringBuilder();
        for (char c : p.toCharArray()) {
            if (sb.length() >= 1 && sb.charAt(sb.length() - 1) == '*' && c == '*') {
                continue;
            }
            sb.append(c);
        }

        p = sb.toString();
        String[] pa = p.split("\\*");

        if (p.charAt(p.length()-1) != '*'){
            if (s.length() < pa[pa.length - 1].length()) {
                return false;
            }
            if (match(s.substring(s.length() - pa[pa.length-1].length()),  pa[pa.length-1])) {
                s = s.substring(0, s.length() - pa[pa.length-1].length());
                p = p.substring(0,p.length() - pa[pa.length-1].length());
                pa = Arrays.copyOfRange(pa, 0, pa.length -1);

            } else {
                return false;
            }
        }


        if (pa.length == 0) {
            if (p.length() == 0) {
                return s.equals("");
            } else if (p.charAt(p.length() -1 ) == '*') {
                return true;
            } else {
                return false;
            }
        }


        int i = 0;
        int index = 0;
        int l = s.length();



        while (i < pa.length) {
            if (pa[i].length() > l - index) {
                return false;
            }
            if (i == 0 && !"".equals(pa[i])) {
                if (!match(s.substring(0, pa[i].length()),pa[i])) {
                    return false;
                } else {
                    index += pa[i].length();
                }
            } else {
                boolean r = false;
                for (; index + pa[i].length() <= l; index++ ){
                    if (match(s.substring(index, index + pa[i].length()), pa[i])) {
                        r = true;
                        break;
                    }
                }

                if (r) {
                    index += pa[i].length();
                } else {
                    return false;
                }

            }
            i++;
        }
        return true;
    }

    public boolean match(String s, String p) {
        for (int i = 0; i < s.length(); i++) {
            if (p.charAt(i) == '?') {
                continue;
            }
            if (p.charAt(i) != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }

}
