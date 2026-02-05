package dsa.linkedlist;

public class MergeInBetweenLinkedList {
    public static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode beforeA = list1;
        for (int i = 0; i < a; i++) {
            beforeA = beforeA.next;
        }

        ListNode afterB = beforeA;
        for (int i = a; i <= b; i++) {
            afterB = afterB.next;
        }

        beforeA.next = list2;
        ListNode list2End = list2;
        while (list2End.next != null) {
            list2End = list2End.next;
        }
        list2End.next = afterB.next;
        return list1;
    }


    public static void main(String[] args) {
        int[] arr1 = {10, 1, 13, 6, 9, 5};
        int[] arr2 = {1000000, 1000001, 1000002};
        int a = 3, b = 4;

        ListNode list1 = createList(arr1);
        ListNode list2 = createList(arr2);

        System.out.println(new MergeInBetweenLinkedList().mergeInBetween(list1, a, b, list2));
    }
}
