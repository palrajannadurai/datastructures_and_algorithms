package dsa.array;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxStreak = 1;
        int currentStreak = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                currentStreak++;
            } else {
                maxStreak = Math.max(currentStreak, maxStreak);
                currentStreak = 1;
            }
        }
        return Math.max(currentStreak, maxStreak);
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,2};
        System.out.println(longestConsecutive(nums));
    }
}
