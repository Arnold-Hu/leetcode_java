import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class P1007 {
    public int minDominoRotations(int[] A, int[] B) {
        int[] upRotaion = new int[7];
        int[] downRotatins = new int[7];
        Set<Integer> avaNumber = new HashSet<>();
        avaNumber.add(A[0]);
        avaNumber.add(B[0]);
        for (int i = 0; i < A.length; i++) {
            Iterator<Integer> iter = avaNumber.iterator();
            while (iter.hasNext()) {
                int candidate = iter.next();
                if (A[i] == candidate && B[i] == candidate) {
                    continue;
                }else if (A[i] == candidate) {
                    downRotatins[candidate]++;
                } else if (B[i] == candidate) {
                    upRotaion[candidate]++;
                } else {
                    iter.remove();
                }
            }
        }
        if (avaNumber.size() == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int ava : avaNumber) {
            if (upRotaion[ava] < min) {
                min = upRotaion[ava];
            }
            if (downRotatins[ava] < min) {
                min = downRotatins[ava];
            }
        }
        return min;
    }
}
