package com.dsa.array;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int n : nums) {
            if (count == 0) {
                candidate = n;
            }
            if (n == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] s = {3, 2, 2, 3, 3, 3, 3, 2, 3};
        System.out.println(majorityElement(s));
    }
}
