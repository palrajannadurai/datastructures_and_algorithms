package dsa.search.partition;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        final int m = nums1.length, n = nums2.length;
        int low = 0, high = m;
        while (low <= high) {
            int cutA = (low + high) / 2;
            int cutB = (m + n + 1) / 2 - cutA;

            int maxLeftA = cutA == 0 ? Integer.MIN_VALUE : nums1[cutA - 1];
            int minRightA = cutA == m ? Integer.MAX_VALUE : nums1[cutA];

            int maxLeftB = cutB == 0 ? Integer.MIN_VALUE : nums2[cutB - 1];
            int minRightB = cutB == n ? Integer.MAX_VALUE : nums2[cutB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                high = cutA - 1;
            } else {
                low = cutA + 1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3}, nums2 = {2};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
    }
}
