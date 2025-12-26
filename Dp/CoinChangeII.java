// https://leetcode.com/problems/coin-change-ii/

import java.util.Arrays;
import java.util.Scanner;

public class CoinChangeII {

    public static int change(int amount, int[] coins) {

        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(n - 1, coins, amount, dp);
    }

    // Memoization helper (unbounded knapsack – count ways)
    public static int helper(int i, int[] coins, int amount, int[][] dp) {

        // Base case: only coin[0] available
        if (i == 0) {
            return (amount % coins[0] == 0) ? 1 : 0;
        }

        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        // Not take current coin
        int notTake = helper(i - 1, coins, amount, dp);

        // Take current coin (unbounded)
        int take = 0;
        if (amount >= coins[i]) {
            take = helper(i, coins, amount - coins[i], dp);
        }

        return dp[i][amount] = take + notTake;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int amount = sc.nextInt();
        int n = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.println(change(amount, coins));

        sc.close();
    }
}
