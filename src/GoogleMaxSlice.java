import java.util.Arrays;

public class GoogleMaxSlice {
    static Integer[] solution(Integer[] N, int K) {
        // find the largest head index
        int maxHeadIndex = -1;
        for (int i = 0; i <= N.length - K; i++) {
            if (maxHeadIndex == -1) {
                maxHeadIndex = i;
            } else {
                if (N[i] > N[maxHeadIndex]) {
                    maxHeadIndex = i;
                }
            }
        }
//        Integer[] ret = new Integer[K];
//        System.out.println(maxHeadIndex);
//        // get the slice
//        for (int i = 0; i < K; i++) {
//            ret[i] = N[i + maxHeadIndex];
//        }
//        return ret;

        return Arrays.copyOfRange(N, maxHeadIndex, maxHeadIndex + K);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new Integer[]{1,4,3,2,5,4}, 4)));
    }
}
