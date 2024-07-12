package com.dsa.array;

import java.util.Arrays;

public class ProductOfArrayExceptItself {

    public static int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        if (n <= 1) {
            return nums;
        }

        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
