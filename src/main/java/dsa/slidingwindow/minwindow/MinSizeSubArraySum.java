package dsa.slidingwindow.minwindow;

public class MinSizeSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, minLen = Integer.MAX_VALUE;
        long sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(new MinSizeSubArraySum().minSubArrayLen(target, nums));
    }
}
