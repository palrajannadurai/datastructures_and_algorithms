package dsa.linkedlist;

public class MergeLinkedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                current.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            current = current.next;
        }
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        System.out.println("Dummy : " + dummy);


        while (list1 != null) {
            current.next = new ListNode(list1.val);
            list1 = list1.next;
            current = current.next;
        }
        while (list2 != null) {
            current.next = new ListNode(list2.val);
            list2 = list2.next;
            current = current.next;
        }
        System.out.println("Dummy : " + dummy);
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);

        new MergeLinkedList().mergeTwoLists(l1, l2);
    }
}

