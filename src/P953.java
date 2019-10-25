import java.util.HashMap;
import java.util.Map;

//In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
//
//        Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
//
//
//
//        Example 1:
//
//        Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//        Output: true
//        Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
//        Example 2:
//
//        Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//        Output: false
//        Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
//        Example 3:
//
//        Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//        Output: false
//        Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
//
//
//        Note:
//
//        1 <= words.length <= 100
//        1 <= words[i].length <= 20
//        order.length == 26
//        All characters in words[i] and order are english lowercase letters.
public class P953 {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length <= 1) {
            return true;
        }
        int[] orderMap = new int[128];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i)] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!compare(words[i], words[i+1], orderMap)) {
                return false;
            }
        }
        return true;
    }

    public boolean compare(String a, String b, int[] orderMap) {
        for (int i = 0; i < a.length(); i++) {
            if (i >= b.length()) {
                return false;
            }
            if (orderMap[a.charAt(i)] < orderMap[b.charAt(i)]) {
                return true;
            } else if (orderMap[a.charAt(i)] > orderMap[b.charAt(i)]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P953 p953 = new P953();
        System.out.println(p953.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(p953.isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
    }
}
