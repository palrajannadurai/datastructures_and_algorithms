package dsa.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyLinkedListRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while(curr != null) {
            map.put(curr, new Node(curr.data));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}
