// https://www.geeksforgeeks.org/problems/longest-common-substring1452/1

import java.util.Scanner;

public class LongestCommonSubstring {

    public static int longestCommonSubstr(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];
        int maxLen = 0;

        // Bottom-up DP
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0; // reset for substring
                }
            }
        }

        return maxLen;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        System.out.println(longestCommonSubstr(s1, s2));

        sc.close();
    }
}
