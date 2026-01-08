package dsa.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class MaximumWidthOfBinaryTree {

    static class Pair {
        int index;
        TreeNode node;

        public Pair(int index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }

    public int widthOfBinaryTreeOptimized(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().index;
            int first = 0, last = 0;
            for (int i = 1; i <= size; i++) {
                Pair it = q.remove();
                TreeNode node = it.node;
                int curr_idx = it.index - min;
                if (i == 1)
                    first = curr_idx;
                if (i == size)
                    last = curr_idx;

                if (node.left != null) {
                    q.add(new Pair(curr_idx * 2 + 1, node.left));
                }
                if (node.right != null) {
                    q.add(new Pair(curr_idx * 2 + 2, node.right));
                }
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;
        Deque<Pair> bfsQueue = new LinkedList<>();
        bfsQueue.offer(new Pair(0, root));
        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            int startIndex = bfsQueue.peek().index;
            int lastIndex = startIndex;
            for (int i = 0; i < size; i++) {
                Pair current = bfsQueue.poll();
                int index = current.index - startIndex;
                lastIndex = index;
                if (current.node.left != null) {
                    bfsQueue.offer(new Pair(2 * index, current.node.left));
                }
                if (current.node.right != null) {
                    bfsQueue.offer(new Pair(2 * index + 1, current.node.right));
                }
            }
            maxWidth = Math.max(maxWidth, lastIndex + 1);
        }
        return maxWidth;
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
