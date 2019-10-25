import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P438 {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new LinkedList<>();
        if (p == null && s == null) {
            return res;
        }
        if (p == "") {
            return res;
        }
        int[] target = new int[128];
        for (char c : p.toCharArray()) {
            target[c] += 1;
        }

        if (s.length() < p.length()) {
            return res;
        }
        int start = 0;
        int tail = p.length();
        char[] ori = s.toCharArray();
        int[] window = new int[128];
        for (int i = 0; i < tail; i++) {
            window[ori[i]] += 1;
        }
        if (check(target, window)) {
            res.add(start);
        }
        while (tail < s.length()) {
            window[ori[tail]] += 1;
            window[ori[start]] -= 1;
            start++;
            tail++;
            if (check(target, window)) {
                res.add(start);
            }

        }
        return res;
    }

    private boolean check(int[] a, int[] b) {
        System.out.println(Arrays.toString(a));
        for (int i = 'a'; i <= 'z'; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
