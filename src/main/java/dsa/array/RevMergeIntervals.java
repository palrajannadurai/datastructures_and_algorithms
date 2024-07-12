package com.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RevMergeIntervals {

    public static int[][] merge(int[][] intervals) {
        // If there's only one interval, return it as it is
        if (intervals.length == 1) {
            return intervals;
        }

        // Sort the intervals based on their start times
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();

        // Initialize the previousInterval with the first interval
        int[] previousInterval = intervals[0];
        int index = 1;
        while (index < intervals.length) {
            // Get the current interval
            int[] currentInterval = intervals[index];

            // Check for overlap between previous and current intervals
            if (previousInterval[1] >= currentInterval[0]) {
                // If there's an overlap, update the end time of previousInterval
                previousInterval[1] = Math.max(previousInterval[1], currentInterval[1]);
            } else {
                // If no overlap, add previousInterval to the result list
                result.add(previousInterval);
                // Update previousInterval to currentInterval for the next iteration
                previousInterval = currentInterval;
            }
            index++;
        }
        result.add(previousInterval);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(intervals);
        for (int[] i : result) {
            System.out.println(Arrays.toString(i));
        }
    }

}
