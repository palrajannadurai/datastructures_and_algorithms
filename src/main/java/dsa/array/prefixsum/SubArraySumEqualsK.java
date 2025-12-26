package dsa.array.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        for (int num : nums) {
            currentSum += num;
            if (sumMap.containsKey(currentSum - k)) {
                count += sumMap.get(currentSum - k);
            }
            sumMap.put(currentSum, sumMap.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }
}
