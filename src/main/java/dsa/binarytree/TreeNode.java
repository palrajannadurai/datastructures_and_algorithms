package dsa.binarytree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }


    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
