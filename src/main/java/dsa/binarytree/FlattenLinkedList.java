package dsa.binarytree;

public class FlattenLinkedList {
    private TreeNode lastVisitedNode = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = lastVisitedNode;
        lastVisitedNode = root;
    }
}
