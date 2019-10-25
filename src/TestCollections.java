import javafx.util.Pair;

import java.util.*;

public class TestCollections {
    public static void main(String[] args) {
        // linkedList can do stack, FIFO queue
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(1);
        linkedList.add(7);
        linkedList.addLast(1);
        linkedList.removeLast();
        linkedList.removeFirst();



        // treeMap  ordered map use
        Map<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 1);
        treeMap.put(2, 1);
        treeMap.put(2,2);
        treeMap.put(0,7);
        System.out.println(treeMap);


        Map<Integer, Integer> treeMapReverse = new TreeMap<Integer, Integer>(Comparator.comparing(x -> x+1, Comparator.reverseOrder()));
        treeMapReverse.put(1, 1);
        treeMapReverse.put(2, 1);
        treeMapReverse.put(2,2);
        treeMapReverse.put(0,7);
        System.out.println(treeMapReverse);

        Map<Integer, Integer> linkMap = new LinkedHashMap<>();
        linkMap.put(1,1);
        linkMap.put(2, 1);
        linkMap.put(0,2);
        System.out.println(linkMap);

        StringBuilder sb = new StringBuilder();
        List<Character> c = new LinkedList<>();
        c.add('1');
        c.add('9');


        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();

    }
}
