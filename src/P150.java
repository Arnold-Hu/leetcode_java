import java.util.Stack;

public class P150 {
    public int evalRPN(String[] tokens) {
        Stack<Long> numbers = new Stack<>();
        Long ret;
        for (String s : tokens) {



            if ("*".equals(s)) {
                long n1 = numbers.pop();
                long n2 = numbers.pop();
                numbers.push(n1 * n2);
            } else if ("/".equals(s)) {
                long n1 = numbers.pop();
                long n2 = numbers.pop();
                numbers.push(n2 / n1);
            }else if ("+".equals(s)) {
                long n1 = numbers.pop();
                long n2 = numbers.pop();
                numbers.push(n2 + n1);
            }else if ("-".equals(s)) {
                long n1 = numbers.pop();
                long n2 = numbers.pop();
                numbers.push(n2 - n1);
            } else {
                numbers.push(Long.valueOf(s));
            }

        }

        return numbers.peek().intValue();
    }
}
