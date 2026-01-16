// https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

import java.util.Scanner;

public class ZeroOneKnapsack {

    public static int zeroOneKnapsack(int[] val, int[] weight, int n, int capacity) {

        // dp[j] = max value with capacity j
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < n; i++) {
            // Traverse backwards to avoid reuse of same item
            for (int j = capacity; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], val[i] + dp[j - weight[i]]);
            }
        }

        return dp[capacity];
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] val = new int[n];
        int[] weight = new int[n];

        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        int capacity = sc.nextInt();

        System.out.println(zeroOneKnapsack(val, weight, n, capacity));

        sc.close();
    }
}
