// https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1

import java.util.Arrays;
import java.util.Scanner;

public class UnboundedKnapsack {

    public static int knapSack(int[] val, int[] wt, int capacity) {

        int n = val.length;
        int[][] dp = new int[n][capacity + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(val, wt, capacity, n - 1, dp);
    }

    // Memoization helper (unbounded knapsack)
    public static int helper(int[] val, int[] wt, int capacity, int i, int[][] dp) {

        // Base case: only item 0 available (can be taken multiple times)
        if (i == 0) {
            return (capacity / wt[0]) * val[0];
        }

        if (dp[i][capacity] != -1) {
            return dp[i][capacity];
        }

        // Not take current item
        int notTake = helper(val, wt, capacity, i - 1, dp);

        // Take current item (unbounded)
        int take = 0;
        if (capacity >= wt[i]) {
            take = val[i] + helper(val, wt, capacity - wt[i], i, dp);
        }

        return dp[i][capacity] = Math.max(take, notTake);
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] val = new int[n];
        int[] wt = new int[n];

        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }

        int capacity = sc.nextInt();

        System.out.println(knapSack(val, wt, capacity));

        sc.close();
    }
}
