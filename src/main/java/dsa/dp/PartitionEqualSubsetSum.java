package dsa.dp;

public class PartitionEqualSubsetSum {
    public boolean canPartitionV1(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target];
        return dfs(nums, 0, 0, target, dp);
    }

    private boolean dfs(int[] nums, int index, int currentSum, int target, boolean[][] dp) {
        if (currentSum == target) {
            return true;
        }
        if (index == nums.length || currentSum > target) {
            return false;
        }
        if (dp[index][currentSum]) {
            return dp[index][currentSum];
        }
        boolean take = dfs(nums, index + 1, currentSum + nums[index], target, dp);
        boolean skip = dfs(nums, index + 1, currentSum, target, dp);
        return dp[index][currentSum] = take || skip;
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum  = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        for (int num: nums) {
            for (int s = target; s >= num; s--) {
                dp[s] = dp[s] || dp[s - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));
    }
}
