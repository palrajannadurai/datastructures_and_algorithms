package dsa.slidingwindow;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {return 0;}
        int left = 0;
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            if (right - left + 1 == k) {
                maxSum = Math.max(sum, maxSum);
                sum -= nums[left];
                left++;
            }
        }
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = {-1};
        int k = 1;
        MaximumAverageSubarrayI instance = new MaximumAverageSubarrayI();
        System.out.println(instance.findMaxAverage(nums, k));
    }
}
