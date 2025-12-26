package dsa.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    private final Queue<Integer> queue;

    public StackUsingQueue() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while (size > 1) {
            queue.offer(queue.poll());
            size--;
        }
    }

    public int pop() {
        return queue.peek() != null ? queue.poll() : -1;
    }

    public int top() {
        return queue.peek() != null ? queue.peek() : -1;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
