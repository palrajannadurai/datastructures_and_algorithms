package dsa.linkedlist;

import java.util.HashMap;
import java.util.Map;


class LRUCache {

    private static class Node {
        private final int key;
        private int value;
        private Node next;
        private Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache = new HashMap<>();
    private final Node head = new Node(-1, -1);
    private final Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        deleteNode(node);
        addToFront(node);
        return node.value;
    }

    private void evict() {
        if (this.capacity == cache.size()) {
            Node tail = this.tail.prev;
            cache.remove(tail.key);
            deleteNode(tail);
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            deleteNode(cache.get(key));
            cache.remove(key);
        }
        evict();
        Node newNode = new Node(key, value);
        addToFront(newNode);
        cache.put(key, newNode);
    }


    private void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addToFront(Node newNode) {
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