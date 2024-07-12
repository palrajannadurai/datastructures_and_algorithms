package dsa.linkedlist;

public class DeleteNodeInLL {

    public static void deleteNode(ListNode node) {
        ListNode prev = null;
        while (node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        assert prev != null;
        prev.next = null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(head);
        deleteNode(node3);
        System.out.println(head);
    }
}
