package dsa.stackandqueue;

import java.util.*;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nge = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int n : nums2) {
            while (!stack.isEmpty() && n > stack.peek()) {
                nge.put(stack.pop(), n);
            }
            stack.push(n);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nge.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}
