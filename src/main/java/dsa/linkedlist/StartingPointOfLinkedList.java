package dsa.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class StartingPointOfLinkedList {

    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> nodeMap = new HashSet<>();
        while (head != null) {
            if (nodeMap.contains(head)) {
                return head;
            }
            nodeMap.add(head);
            head = head.next;
        }
        return null;
    }

    public static ListNode detectCycleV1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            ListNode prev = fast;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (fast != slow) {
                    slow = slow.next;
                    prev = fast;
                    fast = fast.next;
                }
                prev.next = null;
                return fast;
            }
        }
        return null;
    }

    static void removeLoop(ListNode list) {
        if (list == null || list.next == null) {
            return;
        }
        ListNode slow = list;
        ListNode fast = list;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = list;
                ListNode prev = null;
                while (slow != fast && fast != null) {
                    prev = fast;
                    slow = slow.next;
                    fast = fast.next;
                }
                if (prev != null) {
                    prev.next = null;
                }
            }
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(12);
        ListNode node4 = new ListNode(-4);
//        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node2;
        node3.next = node4;
    }
}
