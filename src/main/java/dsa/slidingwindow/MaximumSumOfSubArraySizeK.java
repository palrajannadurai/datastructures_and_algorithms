package dsa.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class MaximumSumOfSubArraySizeK {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < k) {
            return 0;
        }
        int maxSum = 0;
        for (int i = 0; i < n - k; i++) {
            int windowSum = 0;
            boolean isValid = true;
            Set<Integer> visited = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                if (visited.contains(nums[j])) {
                    isValid = false;
                    break;
                }
                windowSum += nums[j];
                visited.add(nums[j]);
            }
            if (isValid) {
                maxSum = Math.max(windowSum, maxSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        MaximumSumOfSubArraySizeK instance = new MaximumSumOfSubArraySizeK();
        System.out.println(instance.maximumSubarraySum(nums, k));
    }
}
