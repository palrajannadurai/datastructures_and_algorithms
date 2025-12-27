package dsa.tutorials;

import java.util.Arrays;

public class BubbleSort {

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {-2, 45, 0, 11, -9};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
