import javafx.util.*;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hubingcheng on 2019/8/21.
 */
//Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
//
//        If the fractional part is repeating, enclose the repeating part in parentheses.
//
//        Example 1:
//
//        Input: numerator = 1, denominator = 2
//        Output: "0.5"
//        Example 2:
//
//        Input: numerator = 2, denominator = 1
//        Output: "2"
//        Example 3:
//
//        Input: numerator = 2, denominator = 3
//        Output: "0.(6)"
public class P166 {
    public String fractionToDecimal(int numerator, int denominator) {
        int flagLeft = numerator > 0 ? 1 : -1;
        int flagRight = denominator > 0 ? 1 : -1;

        long numeratorL = Math.abs(Long.valueOf(numerator));
        long denominatorL = Math.abs(Long.valueOf(denominator));

        long left = numeratorL / denominatorL;
        long right = numeratorL % denominatorL;
        if (right == 0) {
            return String.valueOf(left * flagLeft * flagRight);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        Map<Long, Integer> m = new HashMap<>();
        while (true) {
//            System.out.println(right);
            if (m.containsKey(right)) {
                sb.insert(m.get(right),"(");
                sb.append(")");
                break;
            }
            System.out.println("right " + right);
            System.out.println("count " + count);
            System.out.println("denominator " + denominatorL);
            m.put(right, count);
            right *= 10;

            if (right >= denominatorL) {
                sb.append(right / denominatorL);
                right = right % denominatorL;
                if (right == 0) {
                    break;
                }
            } else {
                sb.append(0);
            }
            count++;



        }

        String n =  left + "." + sb.toString();

        System.out.println("n " + n);

        if (flagLeft * flagRight < 0) {
            return "-" + n;
        } else {
            return n;
        }
    }

    public static void main(String[] args) {
        P166 p166 = new P166();
//        System.out.println(p166.fractionToDecimal(1,1));
//        System.out.println(p166.fractionToDecimal(1,2));
//        System.out.println(p166.fractionToDecimal(2,1));
//        System.out.println(p166.fractionToDecimal(1,3));
//        System.out.println(p166.fractionToDecimal(1,7));
        System.out.println(p166.fractionToDecimal(-1 , -2147483648));

    }
}
