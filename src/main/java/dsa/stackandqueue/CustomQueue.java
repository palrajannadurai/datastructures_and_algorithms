package dsa.stackandqueue;

public class CustomQueue {

    // Array to store queue elements
    int[] queue;

    // Points to the index of the front element
    // Starts at 0 because first valid element will be at index 0
    int front = 0;

    // Points to the last added element
    // Starts at -1 so that first enqueue moves it to index 0
    int rear = -1;

    // Maximum number of elements queue can hold
    // Needed for array size and circular modulo operation
    int capacity;

    // Current number of elements in queue
    // Used to differentiate between FULL and EMPTY states
    int size;

    // Constructor to initialize queue
    public CustomQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.size = 0;
    }

    // Adds an element to the end of the queue
    public void enqueue(int element) {

        // If size == capacity, queue is full
        if (isFull()) {
            throw new RuntimeException("Queue Overflow");
        }

        // Move rear circularly by using modulo
        // This allows reuse of emptied spaces
        rear = (rear + 1) % capacity;

        // Insert element at rear position
        queue[rear] = element;

        // Increase size because a new element is added
        size++;
    }

    // Removes and returns the front element from the queue
    public int dequeue() {

        // If no elements exist, queue underflow
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }

        // Store the front element (FIFO behavior)
        int removed = queue[front];

        // Move front circularly
        // Next element becomes the new front
        front = (front + 1) % capacity;

        // Decrease size because one element is removed
        size--;

        return removed;
    }

    // Returns the front element without removing it
    public int peek() {

        // Can't peek if queue is empty
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }

        // Front always points to current first element
        return queue[front];
    }

    // Queue is full when number of elements equals capacity
    public boolean isFull() {
        return size == capacity;
    }

    // Queue is empty when no elements are present
    public boolean isEmpty() {
        return size == 0;
    }

    // Testing the queue
    public static void main(String[] args) {

        CustomQueue queue = new CustomQueue(5);

        // ✅ Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.peek()); // 10

        // ✅ Dequeue elements
        System.out.println(queue.dequeue()); // 10
        System.out.println(queue.dequeue()); // 20

        // ✅ Circular behavior test
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);

        /*
            Queue elements logically now:
            [30, 40, 50, 60, 70]
            front wraps and rear wraps using modulo
        */

        // ✅ Dequeue all
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }

        // ✅ Edge case test (Uncomment to test underflow)
//         queue.dequeue();
    }
}
