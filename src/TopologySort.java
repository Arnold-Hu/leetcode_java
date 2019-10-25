import java.util.*;

public class TopologySort {

    public List<Integer> topologySort(Map<Integer, Set<Integer>> table){
        Map<Integer, Integer> inScore = new HashMap<>();
        for (Map.Entry<Integer, Set<Integer>> entry : table.entrySet()) {
            inScore.putIfAbsent(entry.getKey(), 0);
            for (int toNode : entry.getValue()) {
                inScore.put(toNode, inScore.getOrDefault(toNode, 0) + 1);
            }
        }

        System.out.println(table);
        System.out.println(inScore);

        List<Integer> ret = new LinkedList<>();
        while (inScore.size() > 0) {
            int zeroInNode = -1;
            for (Map.Entry<Integer, Integer> entry : inScore.entrySet()) {
                if (entry.getValue() == 0) {
                    zeroInNode = entry.getKey();
                }
            }

            if (zeroInNode == -1) {
                return new LinkedList<>();
            }

            ret.add(zeroInNode);
            inScore.remove(zeroInNode);

            if (table.get(zeroInNode).size() > 0) {
                for (int toNode : table.get(zeroInNode)) {
                    inScore.put(toNode, inScore.get(toNode) - 1);
                }
            }

            table.remove(zeroInNode);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.le
        return ret;
    }
    public List<Integer> topologySort(int[][] edges){
        Map<Integer, Set<Integer>> table = new HashMap<>();

        for (int[] edge : edges) {
            table.putIfAbsent(edge[0], new HashSet<>());
            table.putIfAbsent(edge[1], new HashSet<>());
            table.get(edge[0]).add(edge[1]);
        }

        return topologySort(table);
    }

    public static void main(String[] args) {
        TopologySort topologySort = new TopologySort();
        int[][] test = new int[][]{
                {1,2},
                {2,3},
                {1,3},
                {2,5},
                {1,5},
                {5,3}
        };

        System.out.println(topologySort.topologySort(test));
    }



}
