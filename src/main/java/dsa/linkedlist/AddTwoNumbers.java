package dsa.linkedlist;

public class AddTwoNumbers {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            /* Either one might be null if two different length of linked lists */
            int numOne = (l1 != null) ? l1.val : 0;
            int numTwo = (l2 != null) ? l2.val : 0;

            int sum = numOne + numTwo + carry;
            int digit = sum % 10;
            carry = sum / 10;

            /* Adding in to result and changing the tail */
            tail.next = new ListNode(digit);
            tail = tail.next;

            /* Moving the l1 ***/
            if (l1 != null) {
                l1 = l1.next;
            }

            /* Moving the l2 */
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode node11 = new ListNode(5);
        ListNode node22 = new ListNode(6);
        ListNode node33 = new ListNode(4);
        node11.next = node22;
        node22.next = node33;
        ListNode result = addTwoNumbers(node1, node11);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
