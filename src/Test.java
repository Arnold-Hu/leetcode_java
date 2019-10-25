import java.util.Arrays;

public class Test {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length == 1) {
            return A[0];
        }
        int[] maxPoints = new int[A.length];
        maxPoints[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            if (i <= 6) {
                int max = Integer.MIN_VALUE;
                for (int j = 0; j < i; j++) {
                    max = Math.max(maxPoints[j], max);
                    System.out.println(max);
                }
                maxPoints[i] = max + A[i];
            } else {
                int max = Integer.MIN_VALUE;
                for (int j = i - 6; j < i; j++) {
                    max = Math.max(maxPoints[j], max);
                }
                maxPoints[i] = max + A[i];
            }
        }
        return maxPoints[A.length-1];
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.solution(new int[]{-2, 5, 1}));
    }
}
