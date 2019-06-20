//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//    Return all possible palindrome partitioning of s.
//
//    Example:
//
//    Input: "aab"
//    Output:
//    [
//    ["aa","b"],
//    ["a","a","b"]
//    ]

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P131 {
    public int[][] isPa;
    public String str;

    public List<List<String>> partition(String s) {
        isPa = new int[s.length()][s.length()];
        str = s;
        List<List<String>> res = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        run(res, stack, 0, s.toCharArray());
        System.out.println(Arrays.deepToString(isPa));
        return res;
    }



    public void run(List<List<String>> res, Stack<Integer> ends, int start, char[] string) {
        System.out.println(ends);
        System.out.println(start);
        if (ends.size() != 0 && ends.peek() == string.length -1) {
            res.add(convert(ends));
        }
        for (int newEnd = start; newEnd<string.length; newEnd++) {
            if (isPara(string, start, newEnd)) {
                ends.push(newEnd);
                run(res, ends, newEnd +1, string);
                ends.pop();
            }
        }
    }

    public boolean isPara(char[] string, int left, int right) {
        if (isPa[left][right] == 1) {
            return true;
        } else if (isPa[left][right] == -1) {
            return false;
        }

        boolean ret = true;
        while (left < right) {
            if (string[left] != string[right]) {
                ret = false;
                break;
            }
            left++;
            right--;
        }
        isPa[left][right] = ret ? 1 : -1;
        return ret;
    }


    public List<String> convert(Stack<Integer> ends) {
        int start = 0;
        List<String> strings = new LinkedList<>();
        for (int end : ends) {
            strings.add(str.substring(start, end+1));
            start=end+1;
        }
        return strings;
    }



}
