package dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JobSequencing {

    static class Job {
        int id;
        int profit;
        int deadline;

        public Job(int id, int profit, int deadline) {
            this.id = id;
            this.profit = profit;
            this.deadline = deadline;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "id=" + id +
                    ", profit=" + profit +
                    ", deadline=" + deadline +
                    '}';
        }
    }

    public static void jobSequencing(int[] deadline, int[] profit) {
        // Step 1:
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < deadline.length; i++) {
            jobs.add(new Job(i, profit[i], deadline[i]));
        }
        // 2. Sort the highest profit as first
        jobs.sort(Comparator.comparingInt((Job o) -> o.profit).reversed());
        // 3. MaxSlot
        int maxSlot = jobs.stream().mapToInt(job -> job.deadline).max().getAsInt();
        //
        int[] slots = new int[maxSlot + 1];
        Arrays.fill(slots, -1);

        //
        int noOfJobs = 0;
        int noOfProfit = 0;
        for (Job job: jobs) {
            for (int i = job.deadline; i > 0; i--) {
                if (slots[i] == -1) {
                    slots[i] = job.id;
                    noOfJobs++;
                    noOfProfit += job.profit;
                    break;
                }
            }
        }
        System.out.println("No.of jobs we can schedule is " + noOfJobs + ". And the maximum profit is " + noOfProfit);
    }


    public static void main(String[] args) {

        int[] deadline = {4, 1, 1, 1};
        int[] profit = {20, 10, 40, 30};
        jobSequencing(deadline, profit);

    }
}
