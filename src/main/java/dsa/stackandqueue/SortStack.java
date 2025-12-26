package dsa.stackandqueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class SortStack {

    // Time Complexity O(n log n)
    private static Stack<Integer> sortStack(Stack<Integer> stack) {
        Queue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        while (!stack.isEmpty()) {
            minHeap.offer(stack.pop());
        }
        while (!minHeap.isEmpty()) {
            stack.push(minHeap.poll());
        }
        return stack;
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
