package dsa.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLISV1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int lengthOfLIS(int[] nums) {
        return dfs(nums, 0, Integer.MIN_VALUE);
    }

    private int dfs(int[] nums, int index, int prev) {
        if (index == nums.length) {
            return 0;
        }
        int notTake = dfs(nums, index + 1, prev);
        int take = 0;
        if (nums[index] > prev) {
            take = 1 + dfs(nums, index + 1, nums[index]);
        }
        return Math.max(take, notTake);
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    }
}
