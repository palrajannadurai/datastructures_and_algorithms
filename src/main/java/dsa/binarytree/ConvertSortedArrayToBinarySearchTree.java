package dsa.binarytree;

public class ConvertSortedArrayToBinarySearchTree {
    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = helper(nums, start, mid - 1);
        TreeNode right = helper(nums, mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        return helper(nums, start, end);
    }
}
