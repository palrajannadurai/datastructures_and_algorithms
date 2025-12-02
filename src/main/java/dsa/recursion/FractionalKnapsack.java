package dsa.recursion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Item {
    int weight;
    int profit;

    public Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
    }
}


public class FractionalKnapsack {

    public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {

        // constructing item objects  -- O(n)
        List<Item> items = new ArrayList<>(val.length);
        for (int i = 0; i < val.length; i++) {
            items.add(new Item(wt[i], val[i]));
        }

        // sorting the items based weight to profit ratio -- O(n log n)
        items.sort(Comparator.comparingDouble( (Item item) -> (double) item.profit / item.weight).reversed());

        // tracking profit and so far we how much weight we have picked up
        double totalProfit = 0;
        int totalWeight = 0;

        // O(n)
        for (Item item: items) {
            if (item.weight <= capacity - totalWeight) {
                totalProfit += item.profit;
                totalWeight += item.weight;
            } else {
                int remaining = capacity - totalWeight;
                double weightToProfitRatio = (double) item.profit / item.weight;
                totalProfit += remaining * weightToProfitRatio;
                break;
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        int[] profits = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;
        System.out.println(fractionalKnapsack(profits, weights, capacity));

    }
}
