import java.util.*;

//Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
//
//        Note: The input string may contain letters other than the parentheses ( and ).
//
//        Example 1:
//
//        Input: "()())()"
//        Output: ["()()()", "(())()"]
//        Example 2:
//
//        Input: "(a)())()"
//        Output: ["(a)()()", "(a())()"]
//        Example 3:
//
//        Input: ")("
//        Output: [""]
public class P301 {
    public List<String> removeInvalidParentheses(String s) {
        int rightToMove = 0;
        int leftHas = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftHas++;
            } else if (c == ')') {
                if (leftHas == 0) {
                    rightToMove++;
                } else {
                    leftHas--;
                }
            }
        }
        int leftToMove = leftHas;

        Set<String> ret = new HashSet<>();
        StringBuilder mem = new StringBuilder();
        int leftNum = 0;
        int index = 0;
        dfs(s, ret, mem, leftToMove, rightToMove, 0, 0);

        return new ArrayList<>(ret);
    }


    private void dfs(String target, Set<String> ret, StringBuilder sb, int leftToRemove, int rightToRemove, int index, int leftNum) {
        if (index == target.length()) {
            if (leftNum == 0) {
                ret.add(sb.toString());
            }
            return;
        }

        char c = target.charAt(index);
        if (c != '(' && c != ')') {
            sb.append(c);
            dfs(target, ret, sb, leftToRemove, rightToRemove, index+1, leftNum);
            sb.deleteCharAt(sb.length()-1);
        } else if (c == '(') {
            if (leftToRemove > 0) {
                // try remove
                dfs(target, ret, sb, leftToRemove-1, rightToRemove, index+1, leftNum);
            }
            // not remove
            sb.append('(');
            dfs(target, ret, sb, leftToRemove, rightToRemove, index+1, leftNum+1);
            sb.deleteCharAt(sb.length()-1);
        } else {
            if (rightToRemove > 0) {
                dfs(target, ret, sb, leftToRemove, rightToRemove-1, index+1, leftNum);
            }
            if (leftNum == 0) {
                return;
            } else {
                sb.append(')');
                dfs(target, ret, sb, leftToRemove, rightToRemove, index+1, leftNum-1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }


    public static void main(String[] args) {
        P301 p301 = new P301();
        System.out.println(p301.removeInvalidParentheses("()())()"));
        System.out.println(p301.removeInvalidParentheses("(a)())()"));
        System.out.println(p301.removeInvalidParentheses(")("));
    }
}
