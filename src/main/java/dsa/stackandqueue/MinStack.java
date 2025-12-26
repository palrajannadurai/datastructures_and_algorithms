package dsa.stackandqueue;

import java.util.Stack;

class MinStack {
    private static class Node {
        int value;
        int min;

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    private Stack<Node> stack = null;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.add(new Node(val, val));
        } else {
            stack.add(new Node(val, Math.min(stack.peek().min, val)));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }
}