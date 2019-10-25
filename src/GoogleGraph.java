import java.util.*;
//You are given a tree-shaped undirected graph consisting of n nodes labeled 1...n and n-1 edges. The i-th edge connects nodes edges[i][0] and edges[i][1] together.
//        For a node x in the tree, let d(x) be the distance (the number of edges) from x to its farthest node. Find the min value of d(x) for the given tree.
//        The tree has the following properties:
//
//        It is connected.
//        It has no cycles.
//        For any pair of distinct nodes x and y in the tree, there’s exactly 1 path connecting x and y

//        Input: n = 6, 2edges = [[1, 4], [2, 3], [3, 4], [4, 5], [5, 6]]
public class GoogleGraph {
    public int solution(int[][] edges, int n) {
        Map<Integer, List<Integer>> neibors = new HashMap<>();
        for (int[] edge : edges) {
            if (!neibors.containsKey(edge[0])) {
                neibors.put(edge[0], new LinkedList<Integer>());
            }
            if (!neibors.containsKey(edge[1])) {
                neibors.put(edge[1], new LinkedList<Integer>());
            }
            neibors.get(edge[0]).add(edge[1]);
            neibors.get(edge[1]).add(edge[0]);
        }

        return solution(neibors);
    }

    public int solution(Map<Integer, List<Integer>> neibors) {
        int minD = Integer.MAX_VALUE;
        for (int i = 1; i <= neibors.size(); i++) {
            int d = findFarest(neibors, i);
            if (d < minD) {
                minD = d;
            }
        }

        return minD;
    }

    public int findFarest(Map<Integer, List<Integer>> neibors, int nodeIndex) {
        int d = 0;
        Set<Integer> runed = new HashSet<>();
        List<Integer> l1 = new LinkedList<>();
        List<Integer> l2 = new LinkedList<>();
        l1.add(nodeIndex);

        while(runed.size() < neibors.size()) {
            for (int node : l1) {
                for (int neibor : neibors.get(node)) {
                    if (runed.contains(neibor)) {
                        continue;
                    }
                    runed.add(neibor);
                    l2.add(neibor);
                }
            }
            d++;
            l1 = l2;
            l2 = new LinkedList<>();
        }
        return d;
    }

    public static void main(String[] args) {
        GoogleGraph gg = new GoogleGraph();
        System.out.println(gg.solution(new int[][]{
                new int[]{1,4},
                new int[]{2,3},
                new int[]{3,4},
                new int[]{4,5},
                new int[]{5,6}
        }, 6));
        System.out.println(gg.solution(new int[][]{
                new int[]{1,2}
        }, 2));
        System.out.println(gg.solution(new int[][]{
                new int[]{1,2},
                new int[]{2,3},
                new int[]{3,4},
                new int[]{4,5},
                new int[]{5,6},
                new int[]{6,7},
                new int[]{7,8},
                new int[]{8,9},
                new int[]{9,10}
        }, 10));
        System.out.println(gg.solution(new int[][]{
                new int[]{7,8},
                new int[]{7,9},
                new int[]{4,5},
                new int[]{1,3},
                new int[]{3,4},
                new int[]{6,7},
                new int[]{4,6},
                new int[]{2,3},
                new int[]{9,10}
        }, 10));
    }
}
