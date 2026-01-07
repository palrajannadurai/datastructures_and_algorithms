package dsa.binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()) {
            TreeNode p1 = queue.poll();
            TreeNode q1 = queue.poll();
            if (p1 == null && q1 == null) {
                continue;
            }
            if (p1 == null || q1 == null) {
                return false;
            }
            if (p1.val != q1.val) {
                return false;
            }
            queue.add(p1.right);
            queue.add(q1.right);
            queue.add(p1.left);
            queue.add(q1.left);
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
