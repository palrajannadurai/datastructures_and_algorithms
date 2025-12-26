package dsa.stackandqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangle {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        int[] arr = Arrays.copyOf(heights, n + 1);
        arr[n] = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && arr[i] <= arr[deque.peek()]) {
                int height = arr[deque.pop()];
                int left = deque.isEmpty() ? -1 : deque.peek();
                maxArea = Math.max(maxArea, (height * (i - left - 1)));
            }
            deque.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }
}
