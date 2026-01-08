package dsa.binarytree;

import java.util.*;

public class LevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<List<Integer>> result = new LinkedList<>();
        Deque<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        while (!bfsQueue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = bfsQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = bfsQueue.poll();
                temp.add(top.val);
                if (top.right != null) {
                    bfsQueue.add(top.right);
                }
                if (top.left != null) {
                    bfsQueue.add(top.left);
                }
            }
            result.addFirst(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new LevelOrderTraversalII().levelOrderBottom(root));
    }
}
