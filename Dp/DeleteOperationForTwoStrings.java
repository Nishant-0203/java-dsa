// https://leetcode.com/problems/delete-operation-for-two-strings/

import java.util.Scanner;

public class DeleteOperationForTwoStrings {

    public static int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // LCS DP table
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Minimum deletions = (n - LCS) + (m - LCS)
        return n + m - 2 * dp[n][m];
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String word1 = sc.nextLine();
        String word2 = sc.nextLine();

        System.out.println(minDistance(word1, word2));

        sc.close();
    }
}
