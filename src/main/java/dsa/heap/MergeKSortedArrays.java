package dsa.heap;

import java.util.*;

public class MergeKSortedArrays {
    private static List<Integer> mergeKSortedArrays(List<int[]> arrays) {
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt((o) -> o[0]));

        for (int i = 0; i < arrays.size(); i++) {
            if (arrays.get(i).length > 0) {
                minHeap.offer(new int[]{arrays.get(i)[0], i, 0});
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            result.add(top[0]);
            int arrayIndex = top[1];
            int elementIndex = top[2];
            if (elementIndex + 1 < arrays.get(arrayIndex).length) {
                minHeap.offer(new int[]{arrays.get(arrayIndex)[elementIndex + 1], arrayIndex, elementIndex + 1});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<int[]> arrays = new ArrayList<>();
        arrays.add(new int[]{1, 4, 5});
        arrays.add(new int[]{1, 3, 4});
        arrays.add(new int[]{2, 6});

        System.out.println(mergeKSortedArrays(arrays));
    }


}
