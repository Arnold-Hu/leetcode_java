package leetcodeContest;

import javafx.util.Pair;

import javax.swing.*;
import java.util.*;

public class T4 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            pairs.add(new int[]{startTime[i], endTime[i], profit[i]});
        }

        Collections.sort(pairs, (x, y) -> ((y[1] - y[0]) - (x[1] - x[0])));
        Set<int[]> ava = new HashSet<>();
        ava.addAll(pairs);
        return jobScheduling(ava, pairs, 0);


    }

    private int jobScheduling(Set<int[]> ava, List<int[]> list, int index) {
        if (ava.size() == 0 || index == list.size()) {
            return 0;
        }

        int i = jobScheduling(ava, list, index + 1);

        if (ava.contains(list.get(index))) {
            int[] node = list.get(index);
            List<int[]> store = new LinkedList<>();
            Iterator<int[]> iterator = ava.iterator();
            while (iterator.hasNext()) {
                int[] next = iterator.next();
                if (isOverlap(node, next)) {
                    store.add(next);
                    iterator.remove();
                }
            }
            int j = jobScheduling(ava, list, index+1) + node[2];
            if (j > i) {
                i = j;
            }
            ava.addAll(store);
        }

        return i;

    }

    private static boolean isOverlap(int[] i1, int[] i2) {
        if (i1[1] <= i2[0]) {
            return false;
        } else if (i1[0] >= i2[1]) {
            return false;
        } else {
            return true;
        }
    }
}
