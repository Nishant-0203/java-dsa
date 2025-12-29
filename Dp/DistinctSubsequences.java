// https://leetcode.com/problems/distinct-subsequences/

import java.util.Arrays;
import java.util.Scanner;

public class DistinctSubsequences {

    // Memoization helper
    public static int helper(int i, int j, String s, String t, int[][] dp) {

        // All characters of t matched
        if (j < 0) {
            return 1;
        }

        // s exhausted but t still remaining
        if (i < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            // Option 1: match s[i] with t[j]
            // Option 2: skip s[i]
            dp[i][j] = helper(i - 1, j - 1, s, t, dp)
                     + helper(i - 1, j, s, t, dp);
        } else {
            // Skip s[i]
            dp[i][j] = helper(i - 1, j, s, t, dp);
        }

        return dp[i][j];
    }

    public static int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(n - 1, m - 1, s, t, dp);
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.println(numDistinct(s, t));

        sc.close();
    }
}
