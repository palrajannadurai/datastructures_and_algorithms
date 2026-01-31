package dsa.linkedlist;

import java.util.HashMap;
import java.util.Map;


class LRUCache {

    private static class Node {
        final int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 0;
    private final Map<Integer, Node> cache = new HashMap<>();
    private final Node head = new Node(-1, -1);
    private final Node tail = new Node(-1, -1);

    public LRUCache(int capacity) throws IllegalAccessException {
        if (capacity <= 0) {
            throw new IllegalAccessException("Capacity must be non-negative");
        }
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node answer = cache.get(key);
        deleteNode(answer);
        addNode(answer);
        return answer.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            deleteNode(cache.get(key));
            cache.remove(key);
        }
        if (capacity == cache.size()) {
            Node prev = tail.prev;
            deleteNode(prev);
            cache.remove(prev.key);
        }
        Node newNode = new Node(key, value);
        addNode(newNode);
        cache.put(key, newNode);
    }


    private void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addNode(Node newNode) {
        Node oldNext = this.head.next;
        this.head.next = newNode;
        newNode.prev = this.head;
        newNode.next = oldNext;
        oldNext.prev = newNode;
    }

    public static void main(String[] args) throws IllegalAccessException {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.cache);
        lru.put(3, 3);
        System.out.println(lru.cache);
    }

}