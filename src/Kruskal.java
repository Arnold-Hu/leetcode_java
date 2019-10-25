import javafx.util.Pair;

import java.util.*;

public class Kruskal {

    // [from, to, weight]
    public Set<Pair<Integer, Integer>> findPathWithEdges(int[][] graph, int n) {
        PriorityQueue<int[]> minEdgeHeap = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
        Set<Integer> walkedDot = new HashSet<>();
        Set<Pair<Integer, Integer>> minTree = new HashSet<>();
        int[] parent = new int[n+1];
        Arrays.fill(parent, -1);

        for (int[] edge : graph) {
            minEdgeHeap.add(edge);
        }

        while (!minEdgeHeap.isEmpty()) {
            if (minTree.size() == n -1) {
                break;
            }
            int[] edge = minEdgeHeap.poll();
            System.out.println(edge[0] + " " + edge[1]);
            if (findParent(edge[0], parent) == findParent(edge[1], parent)) {
                continue;
            } else {
                parent[findParent(edge[0], parent)] = findParent(edge[1], parent);
                minTree.add(new Pair<>(edge[0], edge[1]));
            }
        }
        return minTree;
    }

    private int findParent(int i, int[] parent) {
        while (parent[i] != -1) {
            i = parent[i];
        }
        return i;
    }


    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal();
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
        System.out.println(kruskal.findPathWithEdges(graph, 6));
    }
}
