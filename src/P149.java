import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P149 {
    public int maxPoints(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }

        if (points.length == 2) {
            return 2;
        }

        Map<Pair<Long, Pair<Long, Long>>, Integer> lines = new HashMap<Pair<Long, Pair<Long,Long>>, Integer>();

        for (int i = 0; i<points.length - 1; i++) {
            for (int j = i+1; j < points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1]== points[j][1]) {
                    continue;
                }
                Pair<Long, Pair<Long, Long>> line = calLine(points[i], points[j]);
                if (!lines.containsKey(line)) {
                    lines.put(line, 0);
                }


            }
        }

        for (int i = 0; i<points.length; i++) {
            Pair<Long, Pair<Long, Long>> line = new Pair<Long, Pair<Long, Long>>((long)-points[i][0], new Pair<>(1L, 0L));
            if (!lines.containsKey(line)) {
                lines.put(line, 0);
            }
        }


        for (int i = 0; i<points.length; i++) {
            for (Pair<Long, Pair<Long, Long>> line : lines.keySet()) {
                if (isIn(line, points[i])) {
                    lines.put(line, lines.get(line) + 1);
                }
            }
        }

        return lines.values().stream().max(Integer::compareTo).get();

    }

    static int gcd(int a, int b) {
        if (a < b) return gcd(b, a);
        if (b == 0) return a;
        return gcd(b, a % b);
    }

        // ax + by + c = 0     return c, a, b
    static Pair<Long, Pair<Long, Long>> calLine(int[] dot1, int[] dot2) {
        if (dot1[0] == dot2[0]) {
            return new Pair<>((long)-dot1[0], new Pair<>(1L, 0L));
        }

        if (dot1[1] == dot2[1]) {
            return new Pair<>((long)-dot1[1], new Pair<>(0L, 1L));
        }

        int a = dot1[1] - dot2[1];
        int b = dot2[0] - dot1[0];
        int c = dot1[0] * (dot2[1] - dot1[1]) - dot1[1] * (dot2[0] - dot1[0]);


        int d = gcd(gcd(Math.abs(a), Math.abs(b)), gcd(Math.abs(b),Math.abs(c)));


        return new Pair<>((long)c / d, new Pair<>((long)a/d, (long)b / d));

    }


    static boolean isIn(Pair<Long, Pair<Long, Long>> line, int[] dot) {
        return line.getKey() + line.getValue().getKey() * dot[0] + line.getValue().getValue() * dot[1] == 0;
    }
}
