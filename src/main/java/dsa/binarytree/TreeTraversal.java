package dsa.binarytree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {

    List<Integer> result = new ArrayList<>();

    private static String stackToString(Stack<TreeNode> stack) {
        StringBuilder sb = new StringBuilder("[ ");
        for (TreeNode node : stack) {
            sb.append(node.val).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }


    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        System.out.println("Start preorder traversal");

        if (root == null) {
            System.out.println("Tree is empty");
            return result;
        }

        stack.push(root);
        System.out.println("Push root: " + root.val);

        while (!stack.isEmpty()) {

            System.out.println("\nStack before pop: " + stackToString(stack));

            TreeNode node = stack.pop();
            System.out.println("Pop node: " + node.val);

            // Visit node
            result.add(node.val);
            System.out.println("Visit (add to result): " + node.val);
            System.out.println("Result so far: " + result);

            // Push right child first
            if (node.right != null) {
                stack.push(node.right);
                System.out.println("Push RIGHT child: " + node.right.val);
            }

            // Push left child
            if (node.left != null) {
                stack.push(node.left);
                System.out.println("Push LEFT child: " + node.left.val);
            }

            System.out.println("Stack after pushes: " + stackToString(stack));
        }

        System.out.println("\nTraversal completed");
        return result;
    }


    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            TreeNode node = stack.pop();
            result.add(node.val);
            current = node.right;
        }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);
        return result;

    }


    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4, null, null);
        TreeNode n5 = new TreeNode(5, null, null);
        TreeNode n6 = new TreeNode(6, null, null);

        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, null, n6);

        TreeNode root = new TreeNode(1, n2, n3);

        preorderTraversal(root);

    }
}
