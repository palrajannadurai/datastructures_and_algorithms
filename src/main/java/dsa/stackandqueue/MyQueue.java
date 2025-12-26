package dsa.stackandqueue;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> mainStack;
    private Stack<Integer> helperStack;

    public MyQueue() {
        mainStack = new Stack<>();
        helperStack = new Stack<>();
    }

    public void push(int x) {
        while (!mainStack.empty()) {
            helperStack.push(mainStack.pop());
        }
        mainStack.push(x);
        while (!helperStack.empty()) {
            mainStack.push(helperStack.pop());
        }
    }

    public int pop() {
        return mainStack.pop();
    }

    public int peek() {
        return mainStack.peek();
    }

    public boolean empty() {
        return mainStack.empty();
    }

}