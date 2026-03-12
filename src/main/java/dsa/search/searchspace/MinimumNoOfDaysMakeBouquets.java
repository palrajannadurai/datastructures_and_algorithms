package dsa.search.searchspace;

public class MinimumNoOfDaysMakeBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int d: bloomDay) {
            low = Math.min(low, d);
            high = Math.max(high, d);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {
        int flowers = 0;
        int bouquets = 0;
        for (int bloom: bloomDay) {
            flowers = bloom <= day ? flowers + 1 : 0;
            if (flowers == k) {
                bouquets++;
                flowers = 0;
            }
        }
        return bouquets >= m;
    }

    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3, k = 1;
        System.out.println(new MinimumNoOfDaysMakeBouquets().minDays(bloomDay, m, k));
    }
}
