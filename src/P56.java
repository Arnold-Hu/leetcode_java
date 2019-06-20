//Given a collection of intervals, merge all overlapping intervals.
//
//    Example 1:
//
//    Input: [[1,3],[2,6],[8,10],[15,18]]
//    Output: [[1,6],[8,10],[15,18]]
//    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//    Example 2:
//
//    Input: [[1,4],[4,5]]
//    Output: [[1,5]]
//    Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//    NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class P56 {
    public int[][] merge(int[][] intervals) {
        List<Pair<Integer, Integer>> ints = new LinkedList<>();
        for (int[] i : intervals) {
            Pair<Integer, Integer> p = new Pair<>(i[0], i[1]);
            Iterator<Pair<Integer, Integer>> iterator = ints.iterator();
            while (iterator.hasNext()) {
                Pair<Integer, Integer> pair = iterator.next();
                if (pair.x > p.y || p.x > pair.y) {
                    continue;
                }
                p = new Pair<>(Math.min(p.x, pair.x), Math.max(p.y, pair.y));
                iterator.remove();
            }
            ints.add(p);
        }
        int[][] ret = new int[ints.size()][2];
        for (int i = 0; i< ints.size(); i++) {
            ret[i] = new int[]{ints.get(i).x, ints.get(i).y};
        }
        return ret;
    }
}
