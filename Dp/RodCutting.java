// https://www.geeksforgeeks.org/problems/rod-cutting0840/1

import java.util.Arrays;
import java.util.Scanner;

public class RodCutting {

    public static int cutRod(int[] price) {

        int n = price.length;
        int capacity = n;

        int[][] dp = new int[n][capacity + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(price, n - 1, capacity, dp);
    }

    // Memoization helper (unbounded knapsack)
    public static int helper(int[] price, int i, int capacity, int[][] dp) {

        // Base case: only rod of length 1 available
        if (i == 0) {
            return capacity * price[0];
        }

        if (dp[i][capacity] != -1) {
            return dp[i][capacity];
        }

        // Not cut at this length
        int notTake = helper(price, i - 1, capacity, dp);

        // Cut rod of length (i + 1) if possible
        int take = 0;
        if (capacity >= i + 1) {
            take = price[i] + helper(price, i, capacity - (i + 1), dp);
        }

        return dp[i][capacity] = Math.max(take, notTake);
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] price = new int[n];

        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }

        System.out.println(cutRod(price));

        sc.close();
    }
}
