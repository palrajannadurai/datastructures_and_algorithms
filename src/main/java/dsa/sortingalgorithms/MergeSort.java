package dsa.sortingalgorithms;


import java.util.Arrays;

public class MergeSort {
    private long mergeSort(int[] nums, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSort(nums, left, mid);
            count += mergeSort(nums, mid + 1, right);
            count += merge(nums, left, mid, right);
        }
        return count;
    }

    private long merge(int[] nums, int left, int mid, int right) {
        int n1 = (mid - left) + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(nums, left, L, 0, L.length);
        System.arraycopy(nums, mid + 1, R, 0, R.length);

        int i = 0;
        int j = 0;
        int k = left;

        long inversions = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k++] = L[i++];
            } else {
                nums[k++] = R[j++];
                inversions += (L.length - i);
            }
        }

        while (i < n1) nums[k++] = L[i++];
        while (j < n2) nums[k++] = R[j++];

        return inversions;
    }

    public static void main(String[] args) {
        int[] nums = {6, 5, 12, 10, 9, 1};
        new MergeSort().mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
