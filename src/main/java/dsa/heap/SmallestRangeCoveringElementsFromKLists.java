package dsa.heap;

import java.util.*;

public class SmallestRangeCoveringElementsFromKLists {

    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums == null || nums.isEmpty()) {
            return new int[]{0, 0};
        }
        // [value, list, pos]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int currentMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[]{val, i, 0});
            currentMax = Math.max(val, currentMax);
        }

        int[] bestRange = new int[]{minHeap.peek()[0], currentMax};

        while (true) {
            int[] smallest = minHeap.poll();
            int listIndex = smallest[1], elementIndex = smallest[2];

            if (elementIndex + 1 == nums.get(listIndex).size()) {
                break;
            }

            final int nextVal = nums.get(listIndex).get(elementIndex + 1);
            currentMax = Math.max(currentMax, nextVal);
            minHeap.offer(new int[]{nextVal, listIndex, elementIndex + 1});
            int currentMin = minHeap.peek()[0];
            if (currentMax - currentMin < bestRange[1] - bestRange[0]) {
                bestRange[0] = currentMin;
                bestRange[1] = currentMax;
            }
        }
        return bestRange;
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();

        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));

        System.out.println(Arrays.toString(new SmallestRangeCoveringElementsFromKLists().smallestRange(nums)));
    }
}
