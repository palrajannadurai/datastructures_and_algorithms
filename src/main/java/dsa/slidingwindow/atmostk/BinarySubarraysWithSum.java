package dsa.slidingwindow.atmostk;

public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMostKSum(nums, goal) - atMostKSum(nums, goal - 1);
    }

    private int atMostKSum(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }
        final int n = nums.length;
        int left = 0, count = 0, sum = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
