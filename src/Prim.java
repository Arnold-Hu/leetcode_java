import javafx.util.Pair;

import java.util.*;

public class Prim {
    // [from, to, weight]
    public Set<Pair<Integer, Integer>> findPathWithEdges(int[][] graph) {
        // initiate new form of graph
        Map<Integer, List<int[]>> newGragh = new HashMap<>();
        for (int[] edge : graph) {
            if (!newGragh.containsKey(edge[0])) {
                newGragh.put(edge[0], new LinkedList<>());
            }
            if (!newGragh.containsKey(edge[1])) {
                newGragh.put(edge[1], new LinkedList<>());
            }
            newGragh.get(edge[0]).add(new int[]{edge[1], edge[2]});
            newGragh.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        return findPathWithEdges(newGragh, graph[0][0]);
    }

    public Set<Pair<Integer, Integer>> findPathWithEdges(Map<Integer, List<int[]>> newGragh, int initDot) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
        Set<Pair<Integer, Integer>> ret = new HashSet<>();
        Set<Integer> walkedDots = new HashSet<>();
        walkedDots.add(initDot);
        for (int[] toPoint : newGragh.get(initDot)) {
            System.out.println(toPoint[0]);
            minHeap.add(new int[]{initDot, toPoint[0], toPoint[1]});
        }

        while (minHeap.size() > 0) {
            int[] edge = minHeap.poll();
            System.out.println(edge[0] + " " + edge[1]);
            if (walkedDots.contains(edge[0]) && walkedDots.contains(edge[1])) {
                continue;
            }
            if (!walkedDots.contains(edge[0])) {
                for (int[] toPoint : newGragh.get(edge[0])) {
                    if (walkedDots.contains(toPoint[0])) {
                        continue;
                    }
                    minHeap.add(new int[]{edge[0], toPoint[0], toPoint[1]});
                }
            }
            if (!walkedDots.contains(edge[1])) {
                for (int[] toPoint : newGragh.get(edge[1])) {
                    if (walkedDots.contains(toPoint[0])) {
                        continue;
                    }
                    minHeap.add(new int[]{edge[1], toPoint[0], toPoint[1]});
                }
            }
            ret.add(new Pair<>(edge[0], edge[1]));
            walkedDots.add(edge[0]);
            walkedDots.add(edge[1]);
            if (ret.size() == newGragh.size() - 1) {
                break;
            }

        }
        return ret;
    }

    public static void main(String[] args) {
        Prim prim = new Prim();
        int[][] graph = new int[][]{
                new int[]{1, 2, 7},
                new int[]{1, 6, 14},
                new int[]{1, 3, 9},
                new int[]{2, 3, 10},
                new int[]{2, 4, 15},
                new int[]{3, 6, 2},
                new int[]{3, 4, 11},
                new int[]{6, 5, 9},
                new int[]{4, 5, 6}
        };
        System.out.println(prim.findPathWithEdges(graph));
    }
}
