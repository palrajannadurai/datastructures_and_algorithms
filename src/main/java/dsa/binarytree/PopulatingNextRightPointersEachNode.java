package dsa.binarytree;

public class PopulatingNextRightPointersEachNode {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node prev = root;
        while (prev.left != null) {
            Node current = prev;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current  = current.next;
            }
            prev = prev.left;
        }
        return root;
    }
}
