package com.sam.ds.algo.practise.greedy;

import java.util.*;

public class JobSequencingProblem {

    static class Job {
        int id, deadline, profit;

        private Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

        static Job of(int id, int deadline, int profit) {
            return new Job(id, deadline, profit);
        }
    }

    static List<Job> sequence(Job[] jobs) {
        int[] slots = new int[jobs.length];
        Arrays.fill(slots, -1);
        Arrays.sort(jobs, Comparator.comparingInt(a -> -a.profit));

        List<Job> result = new ArrayList<>();

        for (int i = 0; i < jobs.length; i++) {
            for (int j = jobs[i].deadline - 1; j >= 0; j--) {
                if (slots[j] == -1) {
                    slots[j] = jobs[i].id;
                    result.add(jobs[i]);
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Job[] jobs = new Job[] {
                Job.of(5, 4, 25),
                Job.of(6, 2, 20),
                Job.of(3, 5, 18),
                Job.of(1, 9, 15),
                Job.of(9, 4, 12),
                Job.of(8, 7, 10),
                Job.of(7, 5, 8),
                Job.of(10, 3, 5),
                Job.of(2, 2, 2),
                Job.of(4, 7, 1)
        };
        List<Job> sequence = sequence(jobs);
        sequence.forEach(job -> System.out.print(job.id + " "));
        int max = sequence.stream().mapToInt(job -> job.profit).sum();
        System.out.println("\nMax Profit = " + max);
    }
}
