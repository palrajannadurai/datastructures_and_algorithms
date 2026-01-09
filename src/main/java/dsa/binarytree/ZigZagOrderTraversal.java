package dsa.binarytree;

import java.util.*;

public class ZigZagOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<List<Integer>> result = new LinkedList<>();
        Deque<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        boolean flip = false;
        while (!bfsQueue.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            int size = bfsQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = bfsQueue.poll();
                if (flip) {
                    temp.addFirst(top.val);
                } else {
                    temp.addLast(top.val);
                }
                if (top.left != null) {
                    bfsQueue.add(top.left);
                }
                if (top.right != null) {
                    bfsQueue.add(top.right);
                }
            }
            flip = !flip;
            result.add(temp);
        }
        return result;
    }
}
