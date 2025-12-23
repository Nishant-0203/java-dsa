// https://leetcode.com/problems/partition-equal-subset-sum/

import java.util.Scanner;

public class PartitionEqualSubsetSum {

    // Memoization helper
    public static boolean helper(int[] nums, int i, int sum, Boolean[][] dp) {

        // Target achieved
        if (sum == 0) {
            return true;
        }

        // Exhausted array or invalid sum
        if (i == nums.length || sum < 0) {
            return false;
        }

        // Already computed
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }

        // Pick current element if possible
        if (sum >= nums[i]) {
            if (helper(nums, i + 1, sum - nums[i], dp)) {
                return dp[i][sum] = true;
            }
        }

        // Not pick current element
        return dp[i][sum] = helper(nums, i + 1, sum, dp);
    }

    public static boolean canPartition(int[] nums) {

        int totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }

        // Odd sum can never be partitioned equally
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];

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

        System.out.println(canPartition(nums));

        sc.close();
    }
}
