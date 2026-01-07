package dsa.binarytree;

import java.util.*;

public class VerticalOrder {
    static class Pair {
        TreeNode data;
        int level;
        int hd;

        public Pair(TreeNode data, int level, int hd) {
            this.data = data;
            this.level = level;
            this.hd = hd;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        // Map<hd, Map<level, Node.val>>
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Deque<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int level = pair.level;
            int hd = pair.hd;
            TreeNode node = pair.data;
            map.computeIfAbsent(hd, k -> new TreeMap<>())
                    .computeIfAbsent(level, k -> new PriorityQueue<>())
                    .add(node.val);
            if (node.right != null) {
                queue.offer(new Pair(node.right, level + 1, hd + 1));
            }
            if (node.left != null) {
                queue.offer(new Pair(node.left, level + 1, hd - 1));
            }
        }

        // Generating result
        List<List<Integer>>  result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> colMap: map.values()) {
            List<Integer> list = new ArrayList<>();
            colMap.values().forEach( pq -> {
                while (!pq.isEmpty()) list.add(pq.poll());
            });
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new VerticalOrder().verticalTraversal(root));
    }
}
