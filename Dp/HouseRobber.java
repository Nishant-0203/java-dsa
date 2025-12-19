import java.util.Arrays;
import java.util.Scanner;

public class HouseRobber {

    // -----------------------------
    //  Memoization (Top-Down DP)
    // Time: O(n), Space: O(n)
    // -----------------------------
    public int robMemo(int idx, int[] nums, int[] dp) {
        if (idx < 0) return 0;
        if (idx == 0) return nums[0];

        if (dp[idx] != -1) return dp[idx];

        int pick = nums[idx] + robMemo(idx - 2, nums, dp);
        int notPick = robMemo(idx - 1, nums, dp);

        return dp[idx] = Math.max(pick, notPick);
    }

    // -----------------------------
    //  Tabulation (Bottom-Up DP)
    // Time: O(n), Space: O(n)
    // -----------------------------
    public int robTabulation(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int pick = nums[i] + dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    }

    // --------------------------------
    //  Space Optimized DP (BEST)
    // Time: O(n), Space: O(1)
    // --------------------------------
    public int robSpaceOptimized(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev2 = nums[0];                    // dp[0]
        int prev1 = Math.max(nums[0], nums[1]); // dp[1]

        for (int i = 2; i < n; i++) {
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
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

        HouseRobber obj = new HouseRobber();

        // Memoization
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println("Memoization: " + obj.robMemo(n - 1, nums, dp));

        // Tabulation
        System.out.println("Tabulation: " + obj.robTabulation(nums));

        // Space Optimized
        System.out.println("Space Optimized: " + obj.robSpaceOptimized(nums));

        sc.close();
    }
}
