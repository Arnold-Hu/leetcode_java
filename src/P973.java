
//We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
//
//        (Here, the distance between two points on a plane is the Euclidean distance.)
//
//        You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P973 {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Pair<Integer, Integer>> dots = new PriorityQueue<>(
                Comparator.comparingInt(P973::distance).reversed());

        for (int[] point :points) {
            if (dots.size() < K) {
                dots.add(new Pair<>(point[0], point[1]));
            } else {
                Pair<Integer, Integer> d = new Pair<>(point[0], point[1]);
                if (distance(d) < distance(dots.peek())) {
                    dots.poll();
                    dots.add(d);
                }
            }
        }
        return dots.stream().map(x -> new int[]{x.getKey(), x.getValue()}).toArray(size -> new int[size][2]);
    }

    private static int distance(Pair<Integer, Integer> dot) {
        return dot.getKey() * dot.getKey() + dot.getValue() * dot.getValue();
    }
}
