//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//    Symbol       Value
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
//    For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
//
//    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
//    I can be placed before V (5) and X (10) to make 4 and 9.
//    X can be placed before L (50) and C (100) to make 40 and 90.
//    C can be placed before D (500) and M (1000) to make 400 and 900.
//    Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P12 {
    private static final Map<Integer, String> INT_TO_ROME = new HashMap<>();
    static {
        INT_TO_ROME.put(1, "I");
        INT_TO_ROME.put(5, "V");
        INT_TO_ROME.put(10, "X");
        INT_TO_ROME.put(50, "L");
        INT_TO_ROME.put(100, "C");
        INT_TO_ROME.put(500, "D");
        INT_TO_ROME.put(1000, "M");
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1000; i >= 1; i = i / 10) {
            int x = num/i;
            if (x == 0) {
                continue;
            }
            num = num - x * i;
            int[] ret;
            switch (x) {
                case 1:
                    ret = new int[]{1};
                    break;
                case 2:
                    ret = new int[]{1,1};
                    break;
                case 3:
                    ret = new int[]{1,1,1};
                    break;
                case 4:
                    ret = new int[]{1,5};
                    break;
                case 5:
                    ret = new int[]{5};
                    break;
                case 6:
                    ret = new int[]{5,1};
                    break;
                case 7:
                    ret = new int[]{5,1,1};
                    break;
                case 8:
                    ret = new int[]{5,1,1,1};
                    break;
                case 9:
                    ret = new int[]{1,10};
                    break;

                    default:
                        throw new RuntimeException();
            }

            for (int digit : ret) {
                sb.append(INT_TO_ROME.get(digit*i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        P12 p12 = new P12();
        System.out.println(p12.intToRoman(27));
        System.out.println(p12.intToRoman(3));
        System.out.println(p12.intToRoman(4));
        System.out.println(p12.intToRoman(9));
        System.out.println(p12.intToRoman(58));
        System.out.println(p12.intToRoman(1994));


    }



}
