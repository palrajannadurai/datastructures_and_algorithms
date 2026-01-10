package dsa.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MorrisTraversal {

    public List<Integer> morrisInOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                result.add(current.val);
                current = current.right;
            } else {
                TreeNode pre = current.right;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }
        return result;
    }

    public List<Integer> morrisPreOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        return Collections.emptyList();
    }
}
