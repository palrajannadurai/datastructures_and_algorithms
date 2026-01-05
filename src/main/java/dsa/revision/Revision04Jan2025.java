package dsa.revision;

import java.util.Arrays;

public class Revision04Jan2025 {
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int start = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                start = i;
                break;
            }
        }

        if (start == -1) {
            reverse(nums, 0, n - 1);
        }

        int end = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[start]) {
                end = i;
                break;
            }
        }

        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        reverse(nums, start + 1, n - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
