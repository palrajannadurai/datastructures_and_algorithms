package com.dsa.array;

public class LeadersInArray {

    private static void printLeaders(int[] nums) {
        final int n = nums.length;
        System.out.print(nums[n - 1] + " ");
        int sum = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] >= sum) {
                System.out.print(nums[i] + " ");
            }
            sum += nums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {16, 17, 4, 3, 5, 2};
        printLeaders(nums);
    }
}
