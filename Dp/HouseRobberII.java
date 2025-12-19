// https://leetcode.com/problems/house-robber-ii/
import java.util.Scanner;

public class HouseRobberII {

    // Helper function for linear house robber (tabulation)
    public int helper(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1) pick += dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    }

    // Main logic for circular houses
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int n = nums.length - 1;

        // Case 1: Exclude first house
        int[] arr1 = new int[n];
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            arr1[j++] = nums[i];
        }
        int ans1 = helper(arr1);

        // Case 2: Exclude last house
        int[] arr2 = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            arr2[k++] = nums[i];
        }
        int ans2 = helper(arr2);

        return Math.max(ans1, ans2);
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

        HouseRobberII obj = new HouseRobberII();
        System.out.println(obj.rob(nums));

        sc.close();
    }
}
