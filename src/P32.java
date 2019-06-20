//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//
//    Example 1:
//
//    Input: "(()"
//    Output: 2
//    Explanation: The longest valid parentheses substring is "()"
//    Example 2:
//
//    Input: ")()())"
//    Output: 4
//    Explanation: The longest valid parentheses substring is "()()"

import java.util.Collections;
import java.util.Stack;

public class P32 {

    public int longestValidParentheses(String s) {
        if (null == s) {
            return 0;
        }

        if (s.length() <= 1) {
            return 0;
        }
        int maxlength = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = 0; i<s.length(); i++) {
            if (st.peek() == -1) {
                st.push(i);
            } else {
                char stackPeek = s.charAt(st.peek());
                char right = s.charAt(i);
                if (stackPeek == '(' && right == ')') {
                    st.pop();
                    maxlength = Math.max(i - st.peek(), maxlength);
                } else {
                    st.push(i);
                }
            }


        }

        return maxlength;
    }

    public static void main(String[] args) {
        P32 p32 = new P32();
        System.out.println(p32.longestValidParentheses("(()"));
        System.out.println(p32.longestValidParentheses(")()())"));
        System.out.println(p32.longestValidParentheses("()(()"));
        System.out.println(p32.longestValidParentheses("(()(((()"));
    }
}
