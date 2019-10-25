import java.util.*;

public class Dijkstra {
    // [from, to, weight]
    // no direction graph
    public List<Integer> findPathWithEdges(int[][] graph, int source, int destination) {
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

        return findPathWithEdges(newGragh, source, destination);
    }

    // the ith list means i is from,  [[to, weight], [to, weight]]
    public List<Integer> findPathWithEdges(Map<Integer, List<int[]>> graph, int source, int destination) {
        // [dot number, pre-dot, distance]
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
        // [pre-dot, distance]
        Map<Integer, int[]> distance = new HashMap<>();
        heap.add(new int[]{source, -1, 0});
        while (!heap.isEmpty()) {
            int[] dot = heap.poll();
            // if already has a shorter way, discard new way
            if (distance.containsKey(dot[0]) && distance.get(dot[0])[1] <= dot[2]) {
                continue;
            }
            distance.put(dot[0], new int[]{dot[1], dot[2]});
            // if the distance has the destination return
            if (dot[0] == destination) {
                break;
            }
            // update all neibor's distance, heap may have overlap with distance
            for (int[] neibor : graph.get(dot[0])) {
                heap.add(new int[]{neibor[0], dot[0], dot[2] + neibor[1]});
            }
        }

        List<Integer> ret = new LinkedList<>();
        ret.add(0, destination);
        while (destination != source) {
            int[] edge = distance.get(destination);
            ret.add(0, edge[0]);
            destination = edge[0];
        }
        return ret;
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        int[][] graph = {
                {1, 2, 7},
                {1, 6, 14},
                {1, 3, 9},
                {2, 3, 10},
                {2, 4, 15},
                {3, 6, 2},
                {3, 4, 11},
                {6, 5, 9},
                {4, 5, 6}
        };
        System.out.println(dijkstra.findPathWithEdges(graph, 1, 5));
    }
}
