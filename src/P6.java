



//Input: s = "PAYPALISHIRING", numRows = 4
//    Output: "PINALSIGYAHRPI"
//    Explanation:
//
//    P     I    N
//    A   L S  I G
//    Y A   H R
//    P     I

public class P6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int p = 2 * numRows - 2;
        int l = s.length();
        StringBuilder sb = new StringBuilder();
        for (int j = 0;j < numRows; j++) {
            int x = 0;
            if (j == 0 || j == numRows - 1) {
                while (true) {
                    if (j + p * x < l) {
                        sb.append(s.charAt(j + p * x));
                    } else {
                        break;
                    }
                    x++;
                }
            } else {
                while (true) {
                    if (j + p * x < l) {
                        sb.append(s.charAt(j + p * x));
                    } else {
                        break;
                    }
                    if (p - j + p * x < l) {
                        sb.append(s.charAt(p - j + p * x));
                    } else {
                        break;
                    }
                    x++;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        P6 p = new P6();
        System.out.println(p.convert("PAYPALISHIRING", 4));
        System.out.println(p.convert("P", 1));
        System.out.println(p.convert("", 4));
    }
}




