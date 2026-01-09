package dsa.binarytree;

public class DiameterOfBinaryTree {
    private int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return this.result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        this.result = Math.max(this.result, left + right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(2);
        root.left = new TreeNode(3);

        root.right.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }
}
