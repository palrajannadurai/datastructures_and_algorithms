package dsa.linkedlist;

public class FlattenMultiLevelLinkedList {
    public static Node createList() {
        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Child lists
        head.next.child = new Node(10);

        head.next.next.child = new Node(7);
        head.next.next.child.child = new Node(11);
        head.next.next.child.child.child = new Node(12);

        head.next.next.next.child = new Node(9);

        head.next.next.next.next.child = new Node(6);
        head.next.next.next.next.child.child = new Node(8);

        return head;
    }
    public static void main(String[] args) {
    }
}
