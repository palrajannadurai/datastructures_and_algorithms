package dsa.binarytree;

import java.util.Deque;
import java.util.LinkedList;


public class MaximumWidthOfBinaryTree {

    static class Pair {
        long index;
        TreeNode node;

        public Pair(long index, TreeNode node) {
            this.index = index;
            this.node = node;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "index=" + index +
                    ", node=" + node +
                    '}';
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<Pair> bfsQueue = new LinkedList<>();
        bfsQueue.offer(new Pair(0, root));
        long ans = 0;
        while (!bfsQueue.isEmpty()) {
            System.out.println(bfsQueue);
            int size = bfsQueue.size();
            long base = bfsQueue.peek().index;
            long start = 0;
            long last = 0;
            for (int i = 0; i < size; i++) {
                Pair current = bfsQueue.poll();
                if (i == 0) start = current.index - base;
                if (i == size - 1) last = base - current.index;
                if (current.node.right != null) {
                    bfsQueue.offer(new Pair(2l * current.index + 1L, current.node.right));
                }
                if (current.node.left != null) {
                    bfsQueue.offer(new Pair(2 * current.index, current.node.left));
                }
            }
            ans = Math.max(ans, (last - start + 1));
        }
        return Math.toIntExact(ans);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right.right = new TreeNode(9);

        System.out.println(new MaximumWidthOfBinaryTree().widthOfBinaryTree(root));

    }
}
