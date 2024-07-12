package com.dsa.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeTwoSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        IntStream.range(0, nums2.length).forEach(i -> nums1[m + i] = nums2[i]);
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

}
