package com.dsa.array;

import java.util.Arrays;

public class RotateArray {

    /*
     * [1, 2, 3, 4, 5]  d = 2
     * 1: [5, 4, 3, 2, 1] # full reverse
     * 2: [4, 5, 3, 2, 1] # up to d-1  position reverse
     * Ans = [4, 5, 1, 2, 3]  # from d to the end of array reverse it
     *
     */
    public static void rotateRight(int[] nums, int d) {
        int n = nums.length;
        d = d % n; // We need to compare the last element with 0'th element.
        reverse(nums, 0, n - 1);
        reverse(nums, 0, d - 1);
        reverse(nums, d, n - 1);

    }

    /*
     * [1, 2, 3, 4, 5]  d = 2
     * 1: [2, 1, 3, 4, 5] # reverse from 0 to d - 1
     * 2: [2, 1, 5, 4, 3] # reverse from d to n -1
     * Ans = [3, 4, 5, 1, 2]  # from d to the end of array reverse it
     *
     */
    public static void rotateLeft(int[] nums, int d) {
        int n = nums.length;
        d = d % n;
        reverse(nums, 0, d - 1);
        reverse(nums, d, n - 1);
        reverse(nums, 0, n - 1);
    }

    private static void reverse(int[] nums, int right, int left) {
        while (right < left) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            right++;
            left--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int d = 2;
        System.out.println("Input: " + Arrays.toString(nums) + " Rotation: " + d);

        rotateRight(nums, d);
        System.out.println("Right rotation: " + Arrays.toString(nums));

        int[] numsOne = {1, 2, 3, 4, 5};

        rotateLeft(numsOne, d);
        System.out.println("Left rotation: " + Arrays.toString(numsOne));
    }
}