package dsa.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MissingAndRepeatingElements {
    public static int[] findMissingRepeatingNumbers(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int[] result = new int[2];
        for (int i = 1; i <= nums.length; i++) {
            if (!freqMap.containsKey(i)) {
                result[1] = i;
            } else if (freqMap.get(i) == 2) {
                result[0] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 4, 6, 3};
        System.out.println(Arrays.toString(findMissingRepeatingNumbers(nums)));

    }
}
