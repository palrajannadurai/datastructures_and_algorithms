package dsa.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithZeroSum {
    public static int longestSubArrayWithZeroSum(int[] nums, int target) {
        int n = nums.length;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                if (currentSum == target) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    public static int longestSubArrayWithZeroSumV1(int[] nums, int target) {
        int n = nums.length;
        int sum = 0, maxLength = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == target) {
                maxLength++;
            }
            if (prefixSumMap.containsKey(sum - target)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(sum - target));
            }
            prefixSumMap.putIfAbsent(sum, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] array = {15, -2, 2, -8, 1, 7, 10};
        System.out.println(longestSubArrayWithZeroSumV1(array, 0));
    }
}
