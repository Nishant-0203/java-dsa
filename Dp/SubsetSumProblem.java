// https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

import java.util.Scanner;

public class SubsetSumProblem {

    // Memoization helper
    static boolean helper(int[] arr, int sum, int i, Boolean[][] dp) {

        // Target achieved
        if (sum == 0) {
            return true;
        }

        // Out of bounds or invalid sum
        if (i == arr.length || sum < 0) {
            return false;
        }

        // Already computed
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }

        // Choice: take or not take current element
        boolean take = helper(arr, sum - arr[i], i + 1, dp);
        boolean notTake = helper(arr, sum, i + 1, dp);

        return dp[i][sum] = take || notTake;
    }

    static Boolean isSubsetSum(int[] arr, int sum) {
        Boolean[][] dp = new Boolean[arr.length][sum + 1];
        return helper(arr, sum, 0, dp);
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

        int sum = sc.nextInt();

        System.out.println(isSubsetSum(arr, sum));

        sc.close();
    }
}
