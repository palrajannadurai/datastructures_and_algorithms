package dsa.search;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {1};
        int target = 0;
        System.out.println(new SearchInRotatedSortedArray().search(nums, target));
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] > target && nums[high] > target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    private void print(int[] nums, int start, int end) {
        for (int idx = start; idx <= end; idx++) {
            System.out.print(nums[idx] + " ");
        }
    }
}
