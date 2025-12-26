package dsa.array.prefixsum;

import java.util.Map;
import java.util.TreeMap;

public class CarPooling {
    public static boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] trip: trips) {
            map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
            map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]);
        }
        int totalPassengers = 0;
        for (Map.Entry<Integer, Integer> trip: map.entrySet()) {
            totalPassengers += trip.getValue();
            if (totalPassengers > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 5;
        System.out.println(carPooling(trips, capacity));
    }
}
