// https://leetcode.com/problems/unique-paths/
import java.util.Arrays;
import java.util.Scanner;

public class UniquePaths {

    // Memoization helper
    public int helper(int m, int n, int i, int j, int[][] dp) {

        // Out of bounds
        if (i >= m || j >= n) {
            return 0;
        }

        // Destination reached
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        return dp[i][j] = helper(m, n, i + 1, j, dp)
                        + helper(m, n, i, j + 1, dp);
    }

    // Main function
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(m, n, 0, 0, dp);
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        UniquePaths obj = new UniquePaths();
        System.out.println(obj.uniquePaths(m, n));

        sc.close();
    }
}
