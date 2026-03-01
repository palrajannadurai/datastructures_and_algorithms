package dsa.slidingwindow.atmostk;

public class NumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostKOddNumbers(nums, k) - atMostKOddNumbers(nums, k - 1);
    }

    private int atMostKOddNumbers(int[] nums, int k) {
        if (k < 0) return 0;
        final int n = nums.length;
        int left = 0, count = 0, oddCount = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] % 2 == 1) {
                oddCount++;
            }
            while (oddCount > k) {
                if (nums[left] % 2 == 1) {
                    oddCount--;
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

}
