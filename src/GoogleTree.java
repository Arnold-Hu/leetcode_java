import java.util.*;
//Given an undirected graph with n nodes labeled 1…n. Some of the nodes are already connected. The i-th edge connects nodes edges[i][0] and edges[i][1] together. Your task is to augment this set of edges with additional edges to connect all the nodes. Find the minimum cost to add new edges between the nodes such that all the nodes are accessible from each other.
//
//        Input:
//
//        n, an int representing the total number of nodes.
//        edges, a list of integer pair representing the nodes already connected by an edge.
//        newEdges, a list where each element is a triplet representing the pair of nodes between which an edge can be added and the cost of addition, respectively (e.g. [1, 2, 5] means to add an edge between node 1 and 2, the cost would be 5).
//        Example 1:
//
//        Input: n = 6, edges = [[1, 4], [4, 5], [2, 3]], newEdges = [[1, 2, 5], [1, 3, 10], [1, 6, 2], [5, 6, 5]]
//        Output: 7
//        Explanation:
//        There’re 3 connected components [1, 4, 5], [2, 3] and [6].
//        We can connect these components into a single component by connecting node 1 to node 2 and node 1 to node 6 at a minimum cost of 5 + 2 = 7.


public class GoogleTree {
    public int solution(int n, int[][] edges , int[][] newEdges) {
        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> x[2] - y[2]);
        int[] parent = new int[n+1];
        Arrays.fill(parent, -1);
        for (int[] newEdge : newEdges) {
            q.add(newEdge);
        }
        for (int[] edge : edges) {
            q.add(new int[]{edge[0], edge[1], 0});
        }
        int cost = 0;
        while(q.size()> 0) {
            int[] e = q.poll();
            int parent0 = findParent(e[0], parent);
            int parent1 = findParent(e[1], parent);
            if (parent0 == parent1) {
                continue;
            }
            cost += e[2];
            parent[parent0] = parent1;
        }
        return cost;
    }

    private int findParent(int index, int[] parent) {
        while (parent[index] != -1) {
            index = parent[index];
        }
        return index;
    }

    public static void main(String[] args) {
        GoogleTree gt = new GoogleTree();
        System.out.println(gt.solution(6,
                new int[][]{{1, 4}, {4, 5}, {2, 3}},
                new int[][]{{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}}));
    }
}
