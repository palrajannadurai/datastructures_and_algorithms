package dsa.stackandqueue;

public class CustomStack {
    private final int[] items;
    int capacity;
    int top = -1;

    Integer min = Integer.MIN_VALUE;

    public CustomStack(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
    }

    private boolean isFull() {
        return top == capacity - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("The stack is overflowing we can't add any elements");
        }
        if (value <= min) {
            min = value;
        }
        items[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty we can't remove any element");
        }
        int val = items[top];
        items[top--] = 0;
        return val;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return items[top];
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(2);
        stack.push(10);
        stack.push(20);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
