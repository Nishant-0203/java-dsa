// https://leetcode.com/problems/longest-common-subsequence/

import java.util.Scanner;

public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Bottom-up DP
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text1 = sc.nextLine();
        String text2 = sc.nextLine();

        System.out.println(longestCommonSubsequence(text1, text2));

        sc.close();
    }
}
