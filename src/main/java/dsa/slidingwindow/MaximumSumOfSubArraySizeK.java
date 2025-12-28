package dsa.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class MaximumSumOfSubArraySizeK {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < k) {
            return 0;
        }
        int left = 0;
        long sum = 0, ans = 0;
        Set<Integer> visited = new HashSet<>(n);
        for (int right = 0; right < n; right++) {
            while (visited.contains(nums[right])) {
                visited.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            sum += nums[right];
            visited.add(nums[right]);

            if (right - left - 1 == k) {
                visited.remove(nums[left]);
                ans = Math.max(sum, ans);
                sum -= nums[left];
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        MaximumSumOfSubArraySizeK instance = new MaximumSumOfSubArraySizeK();
        System.out.println(instance.maximumSubarraySum(nums, k));
    }
}
