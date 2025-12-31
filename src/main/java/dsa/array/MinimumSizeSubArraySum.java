package dsa.array;

public class MinimumSizeSubArraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        long sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int target = 11;
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen(target, nums));
    }
}
