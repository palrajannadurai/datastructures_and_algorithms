package dsa.dp;

public class MaxProductSubArray {
    public int maxProductBF(int[] nums) {
        int n = nums.length;
        int left = 0;
        int product = Integer.MIN_VALUE;
        for (int right = 1; right < n; right++) {
            int currentProduct = 1;
            for (int i = left; i <= right; i++) {
                currentProduct *= nums[i];
            }
            product = Math.max(product, currentProduct);
        }
        return product;
    }

    public int maxProduct(int[] nums) {
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            int tempMax = Math.max(nums[i], Math.max(x * maxEndingHere, x * minEndingHere));
            int tempMin = Math.min(nums[i], Math.min(x * maxEndingHere, x * minEndingHere));
            maxEndingHere = tempMax;
            minEndingHere = tempMin;
            result = Math.max(result, maxEndingHere);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(new MaxProductSubArray().maxProduct(nums));
    }
}
