package dsa.slidingwindow;

public class MaxConsecutiveOneIII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(new MaxConsecutiveOneIII().longestOnes(nums, k));
    }

    public int longestOnes(int[] nums, int k) {
        final int n = nums.length;
        int left = 0, maxLen = 0, onesCount = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] == 1) {
                onesCount++;
            }
            while ((right - left + 1) - onesCount > k) {
                if (nums[left] == 1) {
                    onesCount--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
