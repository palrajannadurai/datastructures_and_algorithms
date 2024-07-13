package dsa.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IsPalindrome {
    /*Time Complexity: O(n)  Space Complexity: O(n)*/
    public static boolean isPalindrome(ListNode head) {
        List<Integer> elements = new ArrayList<>();
        while (head != null) {
            elements.add(head.val);
            head = head.next;
        }
        int start = 0; int end = elements.size() - 1;
        while (start < end && Objects.equals(elements.get(start), elements.get(end))) {
            start++;
            end--;
        }
        return start >= end;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(isPalindrome(head));
    }
}
