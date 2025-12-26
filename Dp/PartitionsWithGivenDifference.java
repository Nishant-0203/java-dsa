// https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1

import java.util.Arrays;
import java.util.Scanner;

public class PartitionsWithGivenDifference {

    // Memoization helper
    public static int helper(int[] arr, int i, int target, int[][] dp) {

        // All elements processed
        if (i == arr.length) {
            return target == 0 ? 1 : 0;
        }

        // Already computed
        if (dp[i][target] != -1) {
            return dp[i][target];
        }

        // Not take current element
        int notTake = helper(arr, i + 1, target, dp);

        // Take current element if possible
        int take = 0;
        if (arr[i] <= target) {
            take = helper(arr, i + 1, target - arr[i], dp);
        }

        return dp[i][target] = take + notTake;
    }

    public static int countPartitions(int[] arr, int diff) {

        int totalSum = 0;
        for (int x : arr) {
            totalSum += x;
        }

        // Invalid cases
        if (totalSum < diff || (totalSum + diff) % 2 != 0) {
            return 0;
        }

        int target = (totalSum + diff) / 2;

        int[][] dp = new int[arr.length][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(arr, 0, target, dp);
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int diff = sc.nextInt();

        System.out.println(countPartitions(arr, diff));

        sc.close();
    }
}
