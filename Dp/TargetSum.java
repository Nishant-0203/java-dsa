// https://leetcode.com/problems/target-sum/

import java.util.Arrays;
import java.util.Scanner;

public class TargetSum {

    public static int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
        int total = 0;

        for (int x : nums) {
            total += x;
        }

        // Impossible cases
        if (Math.abs(target) > total) return 0;
        if ((target + total) % 2 != 0) return 0;

        int sum = (target + total) / 2;

        int[][] dp = new int[n][sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(nums, sum, 0, n, dp);
    }

    // Memoization helper: count subsets with given sum
    public static int helper(int[] nums, int sum, int i, int n, int[][] dp) {

        if (i == n) {
            return sum == 0 ? 1 : 0;
        }

        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }

        // Not take current element
        int notTake = helper(nums, sum, i + 1, n, dp);

        // Take current element if possible
        int take = 0;
        if (nums[i] <= sum) {
            take = helper(nums, sum - nums[i], i + 1, n, dp);
        }

        return dp[i][sum] = take + notTake;
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

        System.out.println(findTargetSumWays(nums, target));

        sc.close();
    }
}
