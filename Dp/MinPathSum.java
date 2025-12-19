// https://leetcode.com/problems/minimum-path-sum/
import java.util.Arrays;
import java.util.Scanner;

public class MinPathSum {

    // Memoization helper
    public int helper(int[][] grid, int m, int n, int i, int j, int[][] dp) {

        // Out of bounds → return very large value
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        // Destination cell
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = helper(grid, m, n, i + 1, j, dp);
        int right = helper(grid, m, n, i, j + 1, dp);

        // Prevent overflow when adding
        int min = Math.min(down, right);
        if (min == Integer.MAX_VALUE) {
            return dp[i][j] = Integer.MAX_VALUE;
        }

        return dp[i][j] = grid[i][j] + min;
    }

    // Main function
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(grid, m, n, 0, 0, dp);
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        MinPathSum obj = new MinPathSum();
        System.out.println(obj.minPathSum(grid));

        sc.close();
    }
}

