// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

import java.util.Scanner;

public class MinimumInsertionStepsToMakeAStringPalindrome {

    public static int minInsertions(String s) {

        // Reverse the string using StringBuilder (efficient)
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();

        int n = s.length();
        int m = rev.length();

        // LCS DP table
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Minimum insertions = length - LPS
        return n - dp[n][m];
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(minInsertions(s));

        sc.close();
    }
}
