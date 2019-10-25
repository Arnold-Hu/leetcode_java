import java.util.List;
import java.util.Stack;

public class Calculator {
    public int cal(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> ops = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        boolean isLastCharNumber = false;
        for (char c : chars) {
            if (isNumber(c)) {
                if (isLastCharNumber) {
                    nums.add(nums.pop() * 10 + c - '0');
                } else {
                    nums.add(c - '0');
                }
                isLastCharNumber = true;
            } else {
                if (ops.isEmpty()) {
                    ops.add(c);
                } else {
                    if (c == ')') {
                        while (ops.peek() != '(') {
                            cal(ops, nums);
                        }
                        // pop (
                        ops.pop();
                    } else if (c == '(') {
                        ops.push(c);
                    } else {
                        while (!ops.isEmpty()){
                            if (priority(ops.peek()) >= priority(c)) {
                                cal(ops, nums);
                            } else {
                                break;
                            }
                        }
                        ops.add(c);
                    }
                }
                isLastCharNumber = false;
            }
        }

        while (!ops.isEmpty()) {
            cal(ops, nums);
        }
        return nums.peek();
    }

    private boolean isNumber(char c) {
        return c <= '9' && c >= '0';
    }

    private void cal(Stack<Character> ops, Stack<Integer> nums) {
        System.out.println(ops);
        System.out.println(nums);
        int n2 = nums.pop();
        int n1 = nums.pop();
        char op = ops.pop();
        nums.push(cal(n1, n2, op));
    }

    private int cal(int n1, int n2, char op) {
        System.out.println("calculate " + n1 + " " + op + " " + n2);
        switch (op) {
            case '+': return n1 + n2;
            case '-': return n1 - n2;
            case '*': return n1 * n2;
            case '/': return n1 / n2;
            default:
                throw new RuntimeException();
        }
    }

    private int priority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 10;
            case '(' :
                return 0;
        }
        return -1;
    }
    public int noBraceCal(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> ops = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        boolean isLastCharNumber = false;
        for (char c : chars) {
            if (isNumber(c)) {
                if (isLastCharNumber) {
                    nums.add(nums.pop() * 10 + c - '0');
                } else {
                    nums.add(c - '0');
                }
                isLastCharNumber = true;
            } else {
                if (ops.isEmpty()) {
                    ops.add(c);
                } else {
                    while (!ops.isEmpty()){
                        if (priority(ops.peek()) >= priority(c)) {
                            cal(ops, nums);
                        } else {
                            break;
                        }
                    }
                    ops.add(c);
                }
                isLastCharNumber = false;
            }
        }

        while (!ops.isEmpty()) {
            cal(ops, nums);
        }
        return nums.peek();
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
//        System.out.println(calculator.cal("(1+1)*5+1/1*9"));
        System.out.println(calculator.noBraceCal("1+1*5+1/1*9"));

    }
}
