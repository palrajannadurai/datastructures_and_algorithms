package dsa.sortingalgorithms;


/*
 *
 * * Recursively divide until it becomes single element and then sort while merging
 * *
 * *
 * **/

import java.util.Arrays;

public class MergeSort {

    private static int[] mergeSort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private static int[] merge(int[] L, int[] R) {
        int i = 0, j = 0, k = 0;
        int[] temp = new int[L.length + R.length];
        while (i < L.length && j < R.length) {
            if (L[i] <= R[j]) {
                temp[k++] = L[i++];
            } else {
                temp[k++] = R[j++];
            }
        }
        while (i < L.length) {
            temp[k++] = L[i++];
        }
        while (j < R.length) {
            temp[k++] = R[j++];
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 12, 10, 9, 1};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

}
