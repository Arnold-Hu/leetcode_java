import java.util.LinkedList;
import java.util.List;

public class CriticalEdge {
    private Integer[] parents;
    private Integer[] backIndex;
    private Integer[] depths;
    List<Integer>[] map;
    private List<List<Integer>> ret = new LinkedList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        parents = new Integer[n];
        backIndex = new Integer[n];
        depths = new Integer[n];
        map = new LinkedList[n];
        for (int i = 0; i< n; i++) {
            map[i] = new LinkedList<>();
        }

        for (List<Integer> pair : connections) {
            map[pair.get(0)].add(pair.get(1));
            map[pair.get(1)].add(pair.get(0));
        }
        this.depths[0] = 0;
        this.backIndex[0] = 0;
        this.parents[0] = -1;
        find(0);
        return ret;

    }


    private void find(int parent) {
        for (int child : this.map[parent]) {
            if (depths[child] != null) {
                if (parents[parent] != null && parents[parent] == child) {
                    continue;
                } else if (backIndex[child] < backIndex[parent]) {
                    backIndex[parent] = backIndex[child];
                }
            } else {
                parents[child] = parent;
                depths[child] = depths[parent] + 1;
                backIndex[child] = depths[child];
                find(child);
                if (backIndex[child] < backIndex[parent]) {
                    backIndex[parent] = backIndex[child];
                }
                if (backIndex[child] > this.depths[parent]) {
                    LinkedList<Integer> edge = new LinkedList<>();
                    edge.add(child);
                    edge.add(parent);
                    ret.add(edge);
                }
            }
        }
    }
}
