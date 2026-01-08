package dsa.binarytree;

import java.util.*;

public class TopAndBottomView {

    static class Pair {
        int hd;
        TreeNode node;

        public Pair(int hd, TreeNode node) {
            this.hd = hd;
            this.node = node;
        }
    }

    public List<Integer> bottomView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Deque<Pair> bfsQueue = new LinkedList<>();
        bfsQueue.add(new Pair(0, root));

        while (!bfsQueue.isEmpty()) {
            Pair pair = bfsQueue.poll();
            int hd = pair.hd;
            TreeNode node = pair.node;
            map.put(hd, node.val);
            if (node.left != null) {
                bfsQueue.add(new Pair(hd - 1, node.left));
            }
            if (node.right != null) {
                bfsQueue.add(new Pair(hd + 1, node.right));
            }

        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);

        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        root.left.left.left = new TreeNode(5);
        root.left.left.left.right = new TreeNode(6);

        System.out.println(new TopAndBottomView().bottomView(root));

    }
}
