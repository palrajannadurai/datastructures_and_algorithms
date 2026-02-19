package dsa.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DepthOfTree {

    static class Pair {
        int depth;
        TreeNode node;

        public Pair(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }


    public int maxBFS(TreeNode root) {
        // BFS/Level Order Traversal
        if (root == null) {
            return 0;
        }
        //
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // this is the count
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                assert top != null;
                if (top.left != null) queue.offer(top.left);
                if (top.right != null) queue.offer(top.right);
            }
        }
        return depth;
    }




    public int maxDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int n = 0;
        Deque<Pair> stack = new ArrayDeque<>();
        stack.add(new Pair(1, root));
        int maxDepth = 0;
        while (!stack.isEmpty()) {
            n++;
            Pair pair = stack.pop();
            int depth = pair.depth;
            TreeNode node = pair.node;
            maxDepth = Math.max(depth, maxDepth);
            if (node.right != null) {
                stack.add(new Pair(depth + 1, node.right));
            }
            if (node.left != null) {
                stack.add(new Pair(depth + 1, node.left));
            }
        }
        System.out.println("n " + n);
        return maxDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new DepthOfTree().maxBFS(root));
    }
}












