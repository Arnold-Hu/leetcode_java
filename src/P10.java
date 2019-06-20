//Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
//
//    '.' Matches any single character.
//    '*' Matches zero or more of the preceding element.
//    The matching should cover the entire input string (not partial).
//
//    Note:
//
//    s could be empty and contains only lowercase letters a-z.
//    p could be empty and contains only lowercase letters a-z, and characters like . or *.
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
//    p = "a*"
//    Output: true
//    Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
//    Example 3:
//
//    Input:
//    s = "ab"
//    p = ".*"
//    Output: true
//    Explanation: ".*" means "zero or more (*) of any character (.)".
//    Example 4:
//
//    Input:
//    s = "aab"
//    p = "c*a*b"
//    Output: true
//    Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
//    Example 5:
//
//    Input:
//    s = "mississippi"
//    p = "mis*is*p*."
//    Output: false

public class P10 {
    public boolean isMatch(String s, String p) {
        if (p.equals(s)) {
            return true;
        }
        if (p == null || "".equals(p)) {
            return false;
        }



        if (p.length() == 1) {
            if (s.length() != 1) {
                return false;
            }
            if (".".equals(p)) {
                return true;
            }
            if (s.equals(p)) {
                return true;
            }
            return false;
        }

        if (p.length() == 2) {
            if ('*' == p.charAt(1)) {
                if ('.' == p.charAt(0)) {
                    return true;
                } else if ("".equals(s)){
                    return true;
                } else {
                    for (char x : s.toCharArray()) {
                        if (x != p.charAt(0)) {
                            return false;
                        }
                    }
                    return true;

                }
            }

            if (p.length() != s.length()) {
                return false;
            }

            return isEqual(s.charAt(0), p.charAt(0)) && isEqual(s.charAt(1), p.charAt(1));
        }


        if (p.charAt(1) != '*') {
            if (s.length() <= 0) {
                return false;
            }
            if (!isEqual(s.charAt(0), p.charAt(0))) {
                return false;
            }
            return isMatch(s.substring(1), p.substring(1));
        } else {
            if (s.length() == 0) {
                return isMatch(s, p.substring(2));
            }
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            if (p.charAt(0) == '.') {
                for (int i=0; i<s.length(); i++) {
                    if (isMatch(s.substring(i+1), p.substring(2))) {
                        return true;
                    }
                }
            } else {
                for (int i=0; i<s.length(); i++) {
                    if (s.charAt(i) != p.charAt(0)) {
                        return false;
                    }
                    if (isMatch(s.substring(i+1), p.substring(2))) {
                        return true;
                    }
                }
            }



        }
        return false;
    }


    private static boolean isEqual(char s, char p) {
        if (p == '.' ) {
            return true;
        }

        return s == p;
    }

    public static void main(String[] args) {
        P10 p10 = new P10();
//        System.out.println(p10.isMatch("aa", "a"));
//        System.out.println(p10.isMatch("aa", "a*"));
//        System.out.println(p10.isMatch("ab", ".*"));
//        System.out.println(p10.isMatch("aab", "c*a*b"));
//        System.out.println(p10.isMatch("mississippi", "mis*is*p*."));
//        System.out.println(p10.isMatch("ab", ".*c"));
//        System.out.println(p10.isMatch("a", "ab*a"));
        System.out.println(p10.isMatch("bbab", "b*a*"));
    }
}
