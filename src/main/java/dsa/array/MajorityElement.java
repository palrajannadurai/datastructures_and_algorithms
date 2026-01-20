package com.dsa.array;

public class MajorityElement {
    /*
    1. Intuition:
    If an element appears more than n/2 times, it will cancel out all others.
    Boyer–Moore Voting works on this idea.

    2. Brute Force:
        Count frequency of every element using nested loops.

    3. Optimized:
        Use Boyer–Moore Voting Algorithm.

    4. Complexity:
        Brute: O(n^2), O(1)
        Optimized: O(n), O(1)
    */

    // Brute
    public int majorityElementBF(int[] nums) {
        for (int num : nums) {
            int count = 0;
            for (int i : nums) if (num == i) count++;
            if (count > nums.length / 2) return num;
        }
        return -1;
    }

    // Optimized
    int majorityElement(int[] nums) {
        int count = 0, candidate = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }


    public static void main(String[] args) {
        int[] s = {3, 2, 2, 3, 3, 3, 3, 2, 3};
        System.out.println(new MajorityElement().majorityElement(s));
    }
}
