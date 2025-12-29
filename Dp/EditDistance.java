// https://leetcode.com/problems/edit-distance/

import java.util.Arrays;
import java.util.Scanner;

public class EditDistance {

    // Memoization helper
    public static int helper(int i, int j, String word1, String word2, int[][] dp) {

        // If first string exhausted, insert remaining characters of word2
        if (i < 0) {
            return j + 1;
        }

        // If second string exhausted, delete remaining characters of word1
        if (j < 0) {
            return i + 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Characters match, no operation needed
        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = helper(i - 1, j - 1, word1, word2, dp);
        } else {
            // Insert, Delete, Replace
            dp[i][j] = 1 + Math.min(
                    helper(i - 1, j, word1, word2, dp),          // delete
                    Math.min(
                            helper(i, j - 1, word1, word2, dp),  // insert
                            helper(i - 1, j - 1, word1, word2, dp) // replace
                    )
            );
        }

        return dp[i][j];
    }

    public static int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(n - 1, m - 1, word1, word2, dp);
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
