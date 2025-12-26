// https://leetcode.com/problems/coin-change/

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = helper(coins, 0, n, dp, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // Memoization helper (unbounded knapsack)
    public static int helper(int[] coins, int i, int n, int[][] dp, int amount) {

        // Exact amount formed
        if (amount == 0) {
            return 0;
        }

        // Invalid state
        if (amount < 0 || i == n) {
            return Integer.MAX_VALUE;
        }

        // Already computed
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        // Not take current coin
        int notTake = helper(coins, i + 1, n, dp, amount);

        // Take current coin (unbounded)
        int take = helper(coins, i, n, dp, amount - coins[i]);
        if (take != Integer.MAX_VALUE) {
            take = 1 + take;
        }

        return dp[i][amount] = Math.min(take, notTake);
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int amount = sc.nextInt();

        System.out.println(coinChange(coins, amount));

        sc.close();
    }
}
