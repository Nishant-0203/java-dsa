// https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1

import java.util.Arrays;
import java.util.Scanner;

public class PerfectSumProblem {

    // Memoization helper
    public static int helper(int[] nums, int i, int target, int[][] dp) {

        // All elements processed
        if (i == nums.length) {
            return target == 0 ? 1 : 0;
        }

        // Already computed
        if (dp[i][target] != -1) {
            return dp[i][target];
        }

        // Not take current element
        int notTake = helper(nums, i + 1, target, dp);

        // Take current element if possible
        int take = 0;
        if (nums[i] <= target) {
            take = helper(nums, i + 1, target - nums[i], dp);
        }

        return dp[i][target] = take + notTake;
    }

    public static int perfectSum(int[] nums, int target) {

        int[][] dp = new int[nums.length][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(nums, 0, target, dp);
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(perfectSum(nums, target));

        sc.close();
    }
}
