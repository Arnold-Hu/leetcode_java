//
//Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
//
//    Return the quotient after dividing dividend by divisor.
//
//    The integer division should truncate toward zero.
//
//    Example 1:
//
//    Input: dividend = 10, divisor = 3
//    Output: 3
//    Example 2:
//
//    Input: dividend = 7, divisor = -3
//    Output: -2
//    Note:
//
//    Both dividend and divisor will be 32-bit signed integers.
//    The divisor will never be 0.
//    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.

public class P29 {
    private static final int HALF_MAX = 1 << 30;

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }

        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            } else {
                return 0;
            }
        }

        boolean isSameOp = (dividend < 0 && divisor < 0) || (dividend >0 && divisor >0);


        int ret = 0;
        int off = 1;
        if (dividend == Integer.MIN_VALUE) {
            if (isSameOp) {
                dividend -= divisor;
            } else {
                dividend += divisor;
            }
            ret += off;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);


        while (true){
            if (dividend < divisor) {
                if (off == 1) {
                    break;
                } else {
                    divisor = divisor >> 1;
                    off = off >> 1;
                }
            } else {
                ret += off;
                dividend -= divisor;
                if (divisor < HALF_MAX) {
                    divisor = divisor << 1;
                    off = off << 1;
                }
            }
        }

        return isSameOp? ret : -ret;



    }

    public static void main(String[] args) {
        P29 p29 = new P29();
        System.out.println(p29.divide(2147483647, 1));
    }
}
