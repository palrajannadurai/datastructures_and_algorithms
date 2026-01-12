package dsa.binarytree;

public class SearchInBinaryTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return root;
        if (root.val == val)
            return root;
        TreeNode treeNode = root.val > val ? root.left : root.right;
        return searchBST(treeNode, val);
    }
}
