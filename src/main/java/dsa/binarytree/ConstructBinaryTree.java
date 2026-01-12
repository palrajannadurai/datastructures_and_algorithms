package dsa.binarytree;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConstructBinaryTree {
    int preIndex = 0;
    Map<Integer, Integer> inOrderMap = new LinkedHashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        final int inOrderLength = inorder.length;
        for (int i = 0; i < inOrderLength; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return build(preorder, 0, inOrderLength - 1);
    }

    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootValue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = inOrderMap.get(rootValue);
        root.right = build(preorder, rootIndex + 1, inEnd);
        root.left = build(preorder, inStart, rootIndex - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        new ConstructBinaryTree().buildTree(preorder, inorder);
    }

}
