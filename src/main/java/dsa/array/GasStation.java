package dsa.array;

public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currentTank = 0;
        int startingPoint = 0;
        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];
            if (currentTank < 0) {
                startingPoint = i + 1;
                currentTank = 0;
            }
        }
        return totalTank >= 0 ? startingPoint : -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
