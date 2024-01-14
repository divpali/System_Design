import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the
 * cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */

public class Design_LRU_Cache {

    /**
     * 5 <-> 4 <-> 3    put(3,30), put(4,40), put(5,50)
     * 4 <-> 5 <-> 3    get(4)
     * 6 <-> 4 <-> 5    put(6,60)
     */

    Node head;
    Node tail;
    int capacity;
    static Map<Integer,Node> map = new HashMap<>();

    public static void main(String[] args) {

        Design_LRU_Cache d = new Design_LRU_Cache(3);
        d.put(3,3);
        d.put(4,4);
        d.put(5,5);
        System.out.println(d.get(4));
        d.put(6,6);
        System.out.println(map);

    }

    public Design_LRU_Cache(int capacity) {
        this.capacity = capacity;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            if (node !=null) {
                remove(node);
                addToHead(node);
                return node.data;
            }
        }
        return -1;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            if (node != null) {
                remove(node);
                addToHead(node);
            }

        } else {
            Node newNode = new Node(val);
            if (map.size()<capacity) {
                map.put(key,newNode);
                addToHead(newNode);
            } else if (map.size() >= capacity){
                map.remove(tail.prev.data);
                remove(tail.prev);
                addToHead(newNode);
            }
        }
    }

    public void remove(Node node) {
        //n1 <--> n2 <--> n3 <--> tail
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }
}

class Node {

    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
