package com.dsa.array;

import java.util.Arrays;

public class LargestNumber {
    public static String largestNumber(int[] nums) {
        int length = nums.length;
        String[] numbers = new String[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numbers, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            sb.append(number);
        }
        return sb.toString().startsWith("0") ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 35, 5, 9};
        System.out.println(largestNumber(nums));
    }
}
