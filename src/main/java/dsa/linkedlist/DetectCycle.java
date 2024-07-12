package dsa.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>(); // O(n)
        while (head != null) {
            System.out.println(head.val + "  " + head.hashCode());
            if (!nodes.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
    /* Floyd warshall cycle detection algorithm */
    public static boolean hasCycleV1(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
//        node3.next = node4;
        System.out.println(hasCycle(node1));
    }
}
