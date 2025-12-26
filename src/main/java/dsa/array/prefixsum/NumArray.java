package dsa.array.prefixsum;

class NumArray {

    int[] prefixSum;

    public NumArray(int[] nums) {
        calculatePrefixSum(nums);
    }
    private void calculatePrefixSum(int[] nums) {
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
    }
    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefixSum[right];
        }
        return prefixSum[right] = prefixSum[left - 1];
    }
}