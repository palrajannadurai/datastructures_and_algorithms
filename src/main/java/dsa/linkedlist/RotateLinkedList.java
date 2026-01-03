package dsa.linkedlist;

public class RotateLinkedList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        current.next = head;
        current = head;
        for (int i = 1; i < length - k; i++) {
            current = current.next;
        }
        head = current.next;
        current.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(rotateRight(head, 2));
    }
}
