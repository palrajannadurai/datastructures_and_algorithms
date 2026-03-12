package dsa.array;

import java.util.Arrays;

public class MaximumLengthPairChain {
    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        int count = 0;
        int lastEnd = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            int left = pair[0];
            int right = pair[1];
            if (left > lastEnd) {
                count++;
                lastEnd = right;
            }
        }
        return count;
    }
}
