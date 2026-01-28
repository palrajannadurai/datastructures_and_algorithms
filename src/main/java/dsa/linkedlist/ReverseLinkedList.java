package dsa.linkedlist;

public class ReverseLinkedList {
    /*
    *
    * * Input: Head = A -> B -> C -> D -> E    Left = 2 Right = 4
    * *
    * * OutPut: A-> D -> C -> B -> E
    * **/
    public static ListNode reverseBetween(ListNode head, int left, int right) {
       if(head == null || left == right) {
           return head;
       }
       ListNode dummy = new ListNode(0, head);
       ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;
        System.out.println("prev " + prev + " current " + prev.next);
        for (int i = 1; i < right - left; i++) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return dummy.next;
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
        int left = 2;
        int right = 4;
        System.out.println(reverseBetween(head, left, right));
    }
}
