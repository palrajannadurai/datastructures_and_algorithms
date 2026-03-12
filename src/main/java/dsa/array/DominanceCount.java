package dsa.array;

public class DominanceCount {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3};
        System.out.println(new DominanceCount().dominantIndices(nums));
    }

    public int dominantIndices(int[] nums) {
        final int n = nums.length;
        long sum = nums[n - 1];
        int dominanceCount = 0;
        int count = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > (sum / count)) {
                dominanceCount++;
            }
            count++;
            sum += nums[i];
        }
        return dominanceCount;
    }
}
