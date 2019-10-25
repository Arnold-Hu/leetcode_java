// hashmap

import javafx.util.Pair;

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
public class P706 {
    private static int INITIAL_CAPACITY = 10000000;
    private static float LOAD_FACTOR = 0.5f;
    private int capacity = INITIAL_CAPACITY;
    private int size = 0;
    private Node[] slots;

    /** Initialize your data structure here. */
    public P706() {
        this.slots = new Node[capacity];
    }


    private void enlargeIfNeed() {
        if (size > capacity * LOAD_FACTOR) {
            reload(capacity * 4);
        }
    }

    private void downsizeIfNeed() {
        if (size < capacity / 10 && size > INITIAL_CAPACITY) {
            reload(capacity / 2);
        }
    }

    private void reload(int newCapacity) {
        Node[] oldSlots = slots;
        slots = new Node[newCapacity];
        for (Node node : oldSlots) {
            size = 0;
            while (node != null) {
                put(node.getKey(), node.getVal());
                node = node.next;
            }
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int position = Math.abs(key) % capacity;
        if (slots[position] == null) {
            slots[position] = new Node(key, value);
            size++;
        } else {
            Node node = slots[position];
            while (node.next != null) {
                if (node.getKey() == key) {
                    node.setVal(value);
                }
            }
            if (node.getKey() == key) {
                node.setVal(value);
            } else {
                node.next = new Node(key, value);
                size++;
            }
        }
        enlargeIfNeed();
    }




    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int position = Math.abs(key) % capacity;
        if (slots[position] == null) {
            return -1;
        }
        Node node = slots[position];
        while (node != null) {
            if (node.getKey() == key) {
                return node.getVal();
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int position = Math.abs(key) % capacity;
        if (slots[position] == null) {
            return;
        }
        Node node = slots[position];
        Node temp;
        if (node.getKey() == key) {
            slots[position] = slots[position].next;
            node.next = null;
            size--;
        } else {
            while (node.next != null) {
                if (node.next.key == key) {
                    temp = node.next;
                    node.next = node.next.next;
                    temp.next = null;
                    size--;
                    break;
                }
            }
        }
        downsizeIfNeed();
    }

    public class Node {
        int key;

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        int val;
        Node next;

        Node(int x, int y) {
            key = x;
            val = y;
        }
    }
}
