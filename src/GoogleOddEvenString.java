//You are given a group of distinct k characters(from a-z). Construct a string of length n such that:
//        No two consecutive positions in string contain the same character
//        The odd positions can only contain characters from initial group of k characters
//        Even positions can contain any character from a to z.
//        Indexing is 1 based. Find number of distinct ways to form such strings modulo 10^9+7.
//        Constraints:
//        0<T<=250
//        0<k<=26
//        0<N<=100000

import java.util.LinkedList;
import java.util.List;

public class GoogleOddEvenString {
    public long solution(int k, int n) {
        int base = (k-1) * (k-1) + (26-k) * k;
        if (n == 1) {
            return k;
        } else if ( n % 2 == 1) {
            return k * (long)Math.pow(base, n/2);
        } else {
            return k * 25 * (long)Math.pow(base, n/2 - 1);
        }
    }

    public static void main(String[] args) {
        GoogleOddEvenString g = new GoogleOddEvenString();
        System.out.println( " " + g.solution(3, 3));
    }
}
