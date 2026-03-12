package dsa.search.searchspace;

public class SplitArrayLargestSum {

    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        System.out.println(new SplitArrayLargestSum().splitArray(nums, 2));
    }

    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for (int n : nums) {
            low = Math.max(low, n);
            high += n;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canSplit(nums, mid, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canSplit(int[] nums, int mid, int k) {
        int sum = 0, count = 1;
        for (int num : nums) {
            if (sum + num > mid) {
                sum = num;
                count++;
                if (count > k) return false;
            } else {
                sum += num;
            }
        }
        return true;
    }

}
