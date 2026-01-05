// https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

import java.util.*;

public class JobSequencingProblem {

    // Find with path compression
    public static int find(int x, int[] parent) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x], parent);
    }

    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        int n = deadline.length;
        int[][] jobs = new int[n][2]; // {profit, deadline}
        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            jobs[i][0] = profit[i];
            jobs[i][1] = deadline[i];
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        // Sort jobs by profit descending
        Arrays.sort(jobs, (a, b) -> b[0] - a[0]);

        // DSU array for slots
        int[] parent = new int[maxDeadline + 1];
        for (int i = 0; i <= maxDeadline; i++) {
            parent[i] = i;
        }

        int count = 0;
        int totalProfit = 0;

        for (int i = 0; i < n; i++) {
            int p = jobs[i][0];
            int d = jobs[i][1];

            int availableSlot = find(d, parent);
            if (availableSlot > 0) {
                count++;
                totalProfit += p;
                parent[availableSlot] = find(availableSlot - 1, parent);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(count);
        result.add(totalProfit);

        return result;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] deadline = new int[n];
        int[] profit = new int[n];

        for (int i = 0; i < n; i++) {
            deadline[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
        }

        ArrayList<Integer> ans = jobSequencing(deadline, profit);
        System.out.println(ans.get(0) + " " + ans.get(1));

        sc.close();
    }
}
