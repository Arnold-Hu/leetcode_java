//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P22 {

    public List<String> generateParenthesis(int n) {

       List<String> l = new LinkedList<>();
       StringBuilder s = new StringBuilder();
       backTrace(l, s, 0, new char[]{'(', ')'}, n*2);
       return l;
    }


    public void backTrace(List<String> ret, StringBuilder s, int sum, char[] bag, int targetLength) {
        if (s.length() == targetLength) {
            if (sum == 0) {
                ret.add(s.toString());
            }
            return;
        }
        if (sum < 0) {
            return;
        }

        for (char c : bag) {
            s.append(c);
            int off = c == '(' ? 1 : -1;
            backTrace(ret, s, sum + off, bag, targetLength);
            s.deleteCharAt(s.length() - 1);
        }
    }


    public static void main(String[] args) {
        P22 p22 = new P22();
        System.out.println(p22.generateParenthesis(1));
        System.out.println(p22.generateParenthesis(2));
        System.out.println(p22.generateParenthesis(3));
        System.out.println(p22.generateParenthesis(4));
    }
}
