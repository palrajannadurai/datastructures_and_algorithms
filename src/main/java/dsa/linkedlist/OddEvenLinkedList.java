package dsa.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return head;
        }
        System.out.println("Original List: " + head);
        ListNode oddDummy = new ListNode(-1);
        ListNode odd = oddDummy;
        ListNode evenDummy = new ListNode(-1);
        ListNode even = evenDummy;
        ListNode curr = head;
        int length = 1;
        while(curr != null) {
            if(length % 2 != 0) {
                odd.next = curr;
                curr = curr.next;
                odd = odd.next;
                odd.next = null;
            } else {
                even.next = curr;
                curr = curr.next;
                even = even.next;
                even.next = null;
            }
            length++;
        }
        System.out.println("ODD: " + oddDummy);
        System.out.println("EVEN: " + evenDummy);
        odd.next = evenDummy.next;
        return oddDummy.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null) {
            return head;
        }
        List<Integer> nums = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            nums.add(curr.val);
            curr = curr.next;
        }
        Collections.sort(nums);
        curr = head;
        for (Integer num : nums) {
            curr.val = num;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // Create nodes from last to first
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);
        System.out.println("Original List: " + head);
        System.out.println(new OddEvenLinkedList().sortList(head));
    }
}
