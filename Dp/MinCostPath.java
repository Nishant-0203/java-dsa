// https://www.geeksforgeeks.org/problems/min-cost-path3833/1

import java.util.Scanner;

public class MinCostPath {

    public static int minCostPath(int[][] cost, int m, int n) {

        int[][] dp = new int[m][n]; 

        // Base case
        dp[0][0] = cost[0][0];

        // First column
        for (int i = 1; i < m; i++) {
            dp[i][0] = cost[i][0] + dp[i - 1][0];
        }

        // First row
        for (int j = 1; j < n; j++) {
            dp[0][j] = cost[0][j] + dp[0][j - 1];
        }

        // Fill rest of dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = cost[i][j]
                        + Math.min(dp[i - 1][j],
                          Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
            }
        }

        return dp[m - 1][n - 1];
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        System.out.println(minCostPath(cost, m, n));

        sc.close();
    }
}
