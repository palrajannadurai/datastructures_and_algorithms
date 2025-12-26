package dsa.stackandqueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementI {
    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {6, 0, 8, 1, 3};
        System.out.println(Arrays.toString(nextGreaterElement(nums)));
    }
}
