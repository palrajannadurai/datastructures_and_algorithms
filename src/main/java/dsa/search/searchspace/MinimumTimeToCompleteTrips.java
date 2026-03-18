package dsa.search.searchspace;

public class MinimumTimeToCompleteTrips {

    public long minimumTime(int[] time, int totalTrips) {
        long low = 1;
        int min = Integer.MAX_VALUE;
        for (int t: time) {
            min = Math.min(min, t);
        }
//        At time t = minTime × totalTrips, the fastest bus alone completes exactly totalTrips trips
        long high = (long) min * totalTrips;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (canMake(time, totalTrips, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canMake(int[] time, int totalTrips, long currentTime) {
        long trips = 0;
        for (int t: time) {
            trips += currentTime / t;
            if (trips >= totalTrips) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] time = {1, 2, 3};
        int totalTrips = 5;

        System.out.println(new MinimumTimeToCompleteTrips().minimumTime(time, totalTrips));
    }
}
