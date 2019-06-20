//The set [1,2,3,...,n] contains a total of n! unique permutations.
//
//    By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
//
//    "123"
//    "132"
//    "213"
//    "231"
//    "312"
//    "321"
//    Given n and k, return the kth permutation sequence.
//
//    Note:
//
//    Given n will be between 1 and 9 inclusive.
//    Given k will be between 1 and n! inclusive.
//    Example 1:
//
//    Input: n = 3, k = 3
//    Output: "213"
//    Example 2:
//
//    Input: n = 4, k = 9
//    Output: "2314"

import java.util.Set;

public class P60 {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] used = new int[n];
        k--;
        int d = n;
        for (int p = 0; p < n; p ++) {
            int pos = k / per(d-1);
            k = k % per(d-1);
            int num = getKthNum(used, pos);
            sb.append(num);
            used[num-1] = 1;
            d--;
        }
        return sb.toString();
    }

    private static int getKthNum(int[] used, int pos) {
        int count = 0;
        int i =0;
        for (; count<pos+1; i++){
            if (used[i] == 0) {
                count++;
            }
        }
        return i;
    }

    private static int per(int i) {
        int ret = 1;
        for (int k=1 ; k <= i; k ++) {
            ret *= k;
        }
        return ret;
    }

    public static void main(String[] args) {
        P60 p60 = new P60();
        System.out.println(p60.getPermutation(3, 3));
    }
}
