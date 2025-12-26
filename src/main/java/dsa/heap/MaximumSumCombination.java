package dsa.heap;

import java.util.*;

public class MaximumSumCombination {
    public static int[] maximumSumCombinationBF(int[] nums1, int[] nums2, int k) {
        List<Integer> sums = new ArrayList<>();
        for (int i : nums1) {
            for (int j : nums2) {
                sums.add(i + j);
            }
        }
        sums.sort(Comparator.reverseOrder());
        return sums.subList(0, k).stream().mapToInt(Integer::intValue).toArray();
    }

    public static List<Integer> maximumSumCombination(int[] nums1, int[] nums2, int k) {
        // sort the elements
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;

        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        maxHeap.offer(new int[]{nums1[n - 1] + nums2[n - 1], n - 1, n - 1});

        Set<String> visited = new HashSet<>();
        visited.add((n - 1) + "," + (n - 1));

        List<Integer> result = new ArrayList<>();

        while (k-- > 0 && !maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            int i = top[1];
            int j = top[2];
            result.add(top[0]);
            // i - 1, j
            if (i - 1 >= 0) {
                String key = (i - 1) + "," + j;
                if (!visited.contains(key)) {
                    maxHeap.offer(new int[]{nums1[i - 1] + nums2[j], i - 1, j});
                }
            }
            // i, j - 1
            if (i - 1 >= 0) {
                String key = i + "," + (j - 1);
                if (!visited.contains(key)) {
                    maxHeap.offer(new int[]{nums1[i] + nums2[j - 1], i, j - 1});
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] n1 = {3, 4, 5};
        int[] n2 = {2, 6, 3};
        System.out.println(maximumSumCombination(n1, n2, 2));
    }

}
