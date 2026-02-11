package dsa.search;

public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        System.out.println(new PeakIndexInMountainArray().peakIndexInMountainArray(nums));
    }
}
