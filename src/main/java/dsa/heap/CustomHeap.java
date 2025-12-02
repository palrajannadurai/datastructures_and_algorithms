package dsa.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomHeap<T> {
    private List<T> elements;
    private final Comparator<T> comparator;

    public CustomHeap(Comparator<T> comparator) {
        this.elements = new ArrayList<>();
        this.comparator = comparator;
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void push(T value) {
        elements.add(value);
        heapifyUp(elements.size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (comparator.compare(elements.get(index), elements.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    public T pop() {
        if (elements.isEmpty()) {
            return null;
        }
        T parent = elements.get(0);
        T last = elements.remove(elements.size() - 1);

        if (!elements.isEmpty()) {
            elements.set(0, last);
            heapifyDown(0);
        }
        return parent;
    }

    private void heapifyDown(int index) {
        int size = elements.size();
        while (true) {
            int right = 2 * index + 2;
            int left = 2 * index + 1;
            int best = index;

            if (left < size && comparator.compare(elements.get(left), elements.get(best)) < 0) {
                best = left;
            }
            if (right < size && comparator.compare(elements.get(right), elements.get(best)) < 0) {
                best = right;
            }
            if (best != index) {
                swap(index, best);
                index = best;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }

    public T peek() {
        return elements.isEmpty() ? null : elements.get(0);
    }

    public static void main(String[] args) {
        CustomHeap<Integer> minHeap = new CustomHeap<Integer>(Comparator.naturalOrder());

        minHeap.push(5);
        minHeap.push(1);
        minHeap.push(9);
        minHeap.push(3);

        System.out.println("MinHeap pop order:");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.pop() + " ");
        }

        CustomHeap<Integer> maxHeap = new CustomHeap<Integer>(Comparator.reverseOrder());

        maxHeap.push(5);
        maxHeap.push(1);
        maxHeap.push(9);
        maxHeap.push(3);
        System.out.println("\n");
        System.out.println("MaxHeap pop order:");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.pop() + " ");
        }
    }

}
