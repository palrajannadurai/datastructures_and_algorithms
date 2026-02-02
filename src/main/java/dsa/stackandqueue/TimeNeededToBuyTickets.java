package dsa.stackandqueue;

public class TimeNeededToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        final int n = tickets.length;
        int time = 0;
        for (int i = 0; i < n; i++) {
            if (i <= k) {
                time += Math.min(tickets[i], tickets[k]);
            } else {
                time += Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return time;
    }

    public static void main(String[] args) {
        int[] tickets = {2, 3, 2};
        int k = 2;
        System.out.println(new TimeNeededToBuyTickets().timeRequiredToBuy(tickets, k));
    }
}
