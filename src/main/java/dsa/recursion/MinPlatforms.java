package dsa.recursion;

import java.util.Arrays;

public class MinPlatforms {

    static int findPlatform(int[] arrival, int[] departure, int n) {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int maxNoOfPlatforms = 1;
        int platformsNeeded = 1;

        int i = 1;
        int j = 0;

        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                platformsNeeded++;
                i++;
            } else {
                platformsNeeded--;
                j++;
            }
            maxNoOfPlatforms = Math.max(maxNoOfPlatforms, platformsNeeded);
        }
        return maxNoOfPlatforms;
    }

    public static void main(String[] args) {
        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};
        System.out.println("Minimum platforms needed: " + findPlatform(arr, dep, arr.length));
    }
}
