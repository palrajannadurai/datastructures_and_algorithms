package com.dsa.array;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        Map<Integer, Integer> numbers = new LinkedHashMap<>(); // Should be avoided
        for (int i : nums) {
            if (!numbers.containsKey(i)) {
                numbers.put(i, 1);
                continue;
            }
            numbers.put(i, numbers.get(i) + 1);
        }
        int k = 0;
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
            if (entry.getValue() >= 2) {
                k = k + 2;
                nums[index++] = entry.getKey();
                nums[index++] = entry.getKey();
                continue;
            }
            nums[index++] = entry.getKey();
            k++;

        }
        return k;
    }

    private static int removeDuplicatesV1(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n != nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = removeDuplicatesV1(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}
