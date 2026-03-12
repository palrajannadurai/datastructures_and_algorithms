package dsa.slidingwindow.atmostk;

public class SubarraysKDifferentIntegers {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(new SubarraysKDifferentIntegers().subarraysWithKDistinct(nums, k));
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostDistinct(nums, k) - atMostDistinct(nums, k - 1);
    }

    private int atMostDistinct(int[] nums, int k) {
        final int n = nums.length;
        int left = 0, count = 0;
        int[] freq = new int[n + 1];
        for (int right = 0; right < n; right++) {
            if (freq[nums[right]] == 0) {
                k--;
            }
            freq[nums[right]]++;
            while (k < 0) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    k++;
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}
