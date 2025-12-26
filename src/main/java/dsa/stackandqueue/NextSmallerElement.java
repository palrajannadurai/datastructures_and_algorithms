package dsa.stackandqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class NextSmallerElement {
    public static int[] nextSmallerElementBF(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }
        return result;
    }

    public static int[] nextSmallerElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            } else {
                result[i] = -1;
            }
            stack.push(arr[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};
        System.out.println(Arrays.toString(nextSmallerElement(arr)));
    }
}
