//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
//    You may assume that the intervals were initially sorted according to their start times.
//
//    Example 1:
//
//    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//    Output: [[1,5],[6,9]]
//    Example 2:
//
//    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//    Output: [[1,2],[3,10],[12,16]]
//    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
//    NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

import java.util.Arrays;

public class P57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ret = new int[intervals.length + 1][2];
        int index = 0;
        boolean flag = false;
        for (int[] inter : intervals) {
            if (flag || newInterval[0] > inter[1]) {
                ret[index] = inter;
                index++;
            } else if (inter[0] > newInterval[1]) {
                ret[index] = newInterval;
                flag = true;
                index++;
                ret[index] = inter;
                index++;
            } else {
                newInterval[0] = Math.min(newInterval[0], inter[0]);
                newInterval[1] = Math.max(newInterval[1], inter[1]);
            }
        }

        if (!flag) {
            ret[index] = newInterval;
            index++;
        }
        return Arrays.copyOf(ret, index);
    }
}
