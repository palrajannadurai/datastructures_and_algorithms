package dsa.stackandqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int a : asteroids) {
            while (!stack.isEmpty() && stack.peekLast() > 0 && a < 0) {
                if (stack.peekLast() < -a) {
                    stack.pollLast();
                } else if (stack.peekLast() == -a) {
                    stack.pollLast();
                    a = 0;
                    break;
                } else {
                    a = 0;
                    break;
                }
            }
            if (a != 0) stack.addLast(a);
        }
        int[] result = new int[stack.size()];
        int index = 0;
        for (int a : stack) {
            result[index++] = a;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] asteroids = {5, -10, -5};
        System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision(asteroids)));
    }
}
