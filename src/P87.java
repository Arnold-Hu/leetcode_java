//Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
//
//    Below is one possible representation of s1 = "great":
//
//    great
//    /    \
//    gr    eat
//    / \    /  \
//    g   r  e   at
//    / \
//    a   t
//    To scramble the string, we may choose any non-leaf node and swap its two children.
//
//    For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
//
//    rgeat
//    /    \
//    rg    eat
//    / \    /  \
//    r   g  e   at
//    / \
//    a   t
//    We say that "rgeat" is a scrambled string of "great".
//
//    Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
//
//    rgtae
//    /    \
//    rg    tae
//    / \    /  \
//    r   g  ta  e
//    / \
//    t   a

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P87 {
    public boolean isScramble(String s1, String s2) {
        return isScramble(s1.toCharArray(), 0, s1.length() -1, s2.toCharArray(), 0, s2.length() -1);
    }

    public boolean isScramble(char[] s1, int start1, int end1, char[] s2, int start2, int end2) {
        System.out.println(start1 + "," + end1);
        System.out.println(start2 + "," + end2);
        System.out.println("=====");

        if (end1 - start1 == 0) {
            return s1[start1] == s2[start2];
        }

        if (end1 - start1 == 1) {
            if (s1[start1] == s2[start2] && s1[end1] == s2[end2]) {
                return true;
            }
            if (s1[start1] == s2[end2] && s1[end1] == s2[start2]) {
                return true;
            }
            return false;
        }


//        int[] left = new int[128];
//        int[] right = new int[128];
//        int[] ori = new int[128];
//        for (int i = 0; i < end1 - start1; i++) {
//            ori[s1[start1 + i]] += 1;
//            left[s2[start2 + i]] += 1;
//            right[s2[end2 - i]] += 1;
//
//            if (Arrays.equals(ori, left)) {
//                if (isScramble(s1, start1, start1 + i, s2, start2, start2 + i)
//                    && isScramble(s1, start1 + i + 1, end1, s2, start2 + i + 1, end2)) {
//                    return true;
//                }
//            }
//            if (Arrays.equals(ori, right)) {
//                if (isScramble(s1, start1, start1 + i, s2, end2 - i, end2)
//                    && isScramble(s1, start1 + i + 1, end1, s2, start2, end2 - i - 1)) {
//                    return true;
//                }
//            }
//        }


        Map<Character, Integer> left = new HashMap<>(s1.length);
        Map<Character, Integer> right = new HashMap<>(s1.length);
        Map<Character, Integer> ori = new HashMap<>(s1.length);


        for (int i = 0; i < end1 - start1; i++) {
            ori.put(s1[start1 + i], ori.getOrDefault(s1[start1 + i], 0) + 1);
            left.put(s2[start2 + i], left.getOrDefault(s2[start2 + i], 0) + 1);
            right.put(s2[end2 - i], right.getOrDefault(s2[end2 - i], 0) + 1);

            System.out.println(ori);
            System.out.println(left);
            System.out.println(right);

            if (ori.equals(left)) {
                if (isScramble(s1, start1, start1 + i, s2, start2, start2 + i)
                    && isScramble(s1, start1 + i + 1, end1, s2, start2 + i + 1, end2)) {
                    return true;
                }
            }
            if (ori.equals(right)) {
                if (isScramble(s1, start1, start1 + i, s2, end2 - i, end2)
                    && isScramble(s1, start1 + i + 1, end1, s2, start2, end2 - i - 1)) {
                    return true;
                }
            }
        }

        return false;


    }

    public static void main(String[] args) {
        P87 p87 = new P87();
        System.out.println(p87.isScramble("abc", "cba"));
//        System.out.println(p87.isScramble("abc".toCharArray(), 1, 2, "cba".toCharArray(), 0, 1));
    }
}
