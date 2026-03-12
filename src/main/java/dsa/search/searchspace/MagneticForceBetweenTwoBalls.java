package dsa.search.searchspace;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        final int n = position.length;
        int low = 1, high = position[ n - 1] - position[0];
        int answer = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(position, mid, m)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

    private boolean canPlace(int[] positions, int mid, int m) {
        int lastPosition = positions[0], count = 1;
        for(int position: positions) {
            if (position - lastPosition >= mid) {
                lastPosition = position;
                count++;
            }
            if (count == m) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] position = {1, 2, 3, 4, 7};
        int m = 3;
        System.out.println(new MagneticForceBetweenTwoBalls().maxDistance(position, m));
    }
}
