package dsa.binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class SymmetricTree {

    private boolean isMirror(TreeNode right, TreeNode left) {
        if (right == null && left == null) {
            return true;
        }
        if (right == null || left == null) {
            return false;
        }
        return right.val == left.val
                && isMirror(right.right, left.left)
                && isMirror(left.right, right.left);
    }

    public boolean isSymmetricR(TreeNode root) {
        return isMirror(root.right, root.left);
    }

    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root.right);
        deque.offer(root.left);
        while (!deque.isEmpty()) {
            TreeNode left = deque.poll();
            TreeNode right = deque.poll();
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            deque.offer(right.right);
            deque.offer(left.left);

            deque.offer(right.left);
            deque.offer(left.right);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.right.right = new TreeNode(2);
        System.out.println(new SymmetricTree().isSymmetric(root));
    }
}
