import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LC931 {

    public static int minFallingPathSum(int[][] A) {
        int[][] B = A.clone();
        IntStream.range(1, A.length).forEach(i -> {
            IntStream.range(0, A[0].length).forEach(j -> {
                if (j == 0) {
                    B[i][j] += Math.min(A[i-1][j], A[i-1][j+1]);
                } else  if (j == A[0].length -1) {
                    B[i][j] += Math.min(A[i-1][j], A[i-1][j-1]);
                } else {
                    B[i][j] += Math.min(A[i-1][j], Math.min(A[i-1][j-1], A[i-1][j+1]));
                }
            });
        });
        Arrays.sort(B[A.length-1]);
        return B[A.length-1][0];

    }
    public static void main(String[] args) {
        int[][] A = {{1,2,3},{4,5,6}, {7,8,9}};
        System.out.println(minFallingPathSum(A));
    }
}
