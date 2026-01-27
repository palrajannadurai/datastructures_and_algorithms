package dsa.linkedlist;

class Node {
    int data;
    Node next;
    Node random;
    Node child;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
        this.random = null;
    }
}