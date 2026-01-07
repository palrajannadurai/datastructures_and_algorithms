package dsa.binarytree;

import java.util.*;

public class DifferentViewsOfBT {

    public List<Integer> leftViewBFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode root, int level, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (level == result.size()) {
            result.add(root.val);
        }
        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }

    public List<Integer> leftView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    assert node != null;
                    result.add(node.val);
                }
                assert node != null;
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = null;
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(4);
        root.right.right = null;
        System.out.println(new DifferentViewsOfBT().leftViewBFS(root));
    }
}
