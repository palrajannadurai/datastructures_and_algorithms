package com.dsa.array;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int farthest = 0;
        final int n = nums.length - 1;
        for (int i = 0; i < n; i++) {
            if (i > farthest) {
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]);
        }
        return farthest >= n;
    }

    public static int canJump2(int[] nums) {
        final int n = nums.length - 1;
        int farthest = 0;
        int jumps = 0;
        int currentHead = 0;
        for (int i = 0; i < n; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentHead) {
                jumps++;
                currentHead = farthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));

    }
}
