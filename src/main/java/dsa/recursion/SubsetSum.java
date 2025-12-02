package dsa.recursion;

public class SubsetSum {

    static boolean hasSubsetSumExists(int[] nums, int n, int target) {
        if (target == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (nums[n - 1] > target) {
            return hasSubsetSumExists(nums, n - 1, target);
        }
        return hasSubsetSumExists(nums, n - 1, target) || hasSubsetSumExists(nums, n - 1, target - nums[n - 1]);
    }

    // TODO: DP/Memoization technique we have to use

    public static void main(String[] args) {
        int[] arr = {};
        int target = 0;
        System.out.println(hasSubsetSumExists(arr, arr.length, target));
    }

}
