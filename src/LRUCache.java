//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
//    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//    put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
//    The cache is initialized with a positive capacity.
//
//    Follow up:
//    Could you do both operations in O(1) time complexity?
//
//    Example:
//
//    LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//    cache.put(1, 1);
//    cache.put(2, 2);
//    cache.get(1);       // returns 1
//    cache.put(3, 3);    // evicts key 2
//    cache.get(2);       // returns -1 (not found)
//    cache.put(4, 4);    // evicts key 1
//    cache.get(1);       // returns -1 (not found)
//    cache.get(3);       // returns 3
//    cache.get(4);       // returns 4

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Map<Integer, BiNode> map;
    BiNode head = new BiNode(-1);
    int cap;
    Integer lastKey;
    public LRUCache(int capacity) {
       map = new HashMap<>();
       cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        BiNode node = map.get(key);
        if (map.size() > 1) {
            // cut
            node.pre.next = node.next;
            if (node.next != null) {
                node.next.pre = node.pre;
            } else {
                lastKey = node.pre.val2;
            }
            // insert
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
        }

        return node.val;
    }

    public void put(int key, int value) {
        System.out.println(map);
        if (map.containsKey(key)) {
            BiNode node = map.get(key);
            node.val = value;
            if (map.size() > 1) {
                // cut
                node.pre.next = node.next;
                if (node.next != null) {
                    node.next.pre = node.pre;
                } else {
                    lastKey = node.pre.val2;
                }
                // insert
                node.next = head.next;
                head.next.pre = node;
                head.next = node;
                node.pre = head;
            }
        } else {
            if (map.size() == cap) {
                BiNode lastNode = map.get(lastKey);
                lastNode.pre.next = null;
                map.remove(lastKey);
                lastKey = lastNode.pre.val2;
            }

            BiNode node = new BiNode(value);
            node.val2 = key;

            if (map.size() == 0) {
                head.next = node;
                node.pre = head;
                lastKey = node.val2;
            } else {
                node.pre = head;
                node.next = head.next;
                node.next.pre = node;
                head.next = node;
            }

            map.put(key, node);

        }

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */