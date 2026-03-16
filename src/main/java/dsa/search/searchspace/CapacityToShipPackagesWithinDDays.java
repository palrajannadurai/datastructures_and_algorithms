package dsa.search.searchspace;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for (int weight: weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canShip(weights, days, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int neededDays = 1;
        int currentLoad = 0;
        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                neededDays++;
                currentLoad = weight;
                if (neededDays > days) {
                    return false;
                }
            } else {
                currentLoad += weight;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(new CapacityToShipPackagesWithinDDays().shipWithinDays(weights, days));
    }
}
