package dsa.linkedlist;

import java.util.Stack;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        Stack<Integer> nodes = new Stack<>();
        while (head != null) {
            nodes.push(head.val);
            head = head.next;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!nodes.isEmpty()) {
            tail.next = new ListNode(nodes.pop());
            tail = tail.next;
        }
        return dummyHead.next;
    }

    public static ListNode reverseListV1(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
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
        System.out.println(reverseListV1(head).toString());
    }
}
