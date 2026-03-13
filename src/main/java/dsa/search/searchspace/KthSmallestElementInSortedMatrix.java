package dsa.search.searchspace;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int[] nums: matrix) {
            for (int num: nums) {
                queue.offer(num);
                while (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        System.out.println(new KthSmallestElementInSortedMatrix().kthSmallest(matrix, k));
    }
}
