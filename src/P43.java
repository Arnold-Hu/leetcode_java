//
//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//
//    Example 1:
//
//    Input: num1 = "2", num2 = "3"
//    Output: "6"
//    Example 2:
//
//    Input: num1 = "123", num2 = "456"
//    Output: "56088"
//    Note:
//
//    The length of both num1 and num2 is < 110.
//    Both num1 and num2 contain only digits 0-9.
//    Both num1 and num2 do not contain any leading zero, except the number 0 itself.
//    You must not use any built-in BigInteger library or convert the inputs to integer directly.

public class P43 {
    public static void main(String[] args) {
        P43 p43 = new P43();
        System.out.println(p43.multiply("2", "3"));
        System.out.println(p43.multiply("123", "456"));
    }


    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int[] ret = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int start = i + j;
                int m = (num1.charAt(num1.length() - 1 - i) - '0') * (num2.charAt(num2.length()-1-j) - '0');
                while (m != 0) {
                    ret[start] += m % 10;
                    m /= 10;
                    start++;
                }
            }
        }

        for (int i=0; i<ret.length - 1; i++) {
            if (ret[i] > 9) {
                ret[i+1] += ret[i] / 10;
                ret[i] = ret[i] % 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<ret.length; i++) {
            if (i == ret.length - 1 && ret[i] == 0) {
                continue;
            }
            sb.append(ret[i]);
        }

        return sb.reverse().toString();

    }


}
