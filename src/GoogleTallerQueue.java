import java.util.ArrayList;
import java.util.List;

public class GoogleTallerQueue {
    static int solution(Integer[] A) {
        // Your solution goes here.
        List<Integer> q = new ArrayList<>();
        for (int a : A) {
            int insertIndex = search(q, a);
            if (insertIndex >= q.size()) {
                q.add(a);
            } else {
                q.set(insertIndex, a);
            }
        }
        return q.size();
    }

    static int search(List<Integer> integers, int target) {
        return search(integers, target, 0, integers.size()-1);
    }

    // find first larger position
    static int search(List<Integer> integers, int target, int startIndex, int endIndex) {
        if (integers.size() == 0) {
            return 0;
        }
        if (integers.get(startIndex) > target) {
            return startIndex;
        }
        if (integers.get(endIndex) <= target) {
            return endIndex + 1;
        }
        int mid = (startIndex + endIndex) / 2;
        if (integers.get(mid) <= target) {
            return search(integers, target, mid + 1, endIndex);
        } else {
            return search(integers, target, startIndex, mid);
        }
    }

}
