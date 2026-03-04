package dsa.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        final int n = nums.length;
        int[] result = new int[n - k + 1];
        int left = 0, idx = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int right = 0; right < n; right++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[right]) {
                queue.pollLast();
            }
            queue.offerLast(right);
            if (right - left + 1 >= k) {
                result[idx++] = nums[queue.peekFirst()];
                if(queue.peekFirst() == left)  {
                    queue.pollFirst();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(nums, k)));
        // [3,3,5,5,6,7]
    }
}
