import java.util.Scanner;

public class FrogJump {

    // -------------------------
    //  Tabulation (DP Array)
    // Time: O(n), Space: O(n)
    // -------------------------
    public int minCostTabulation(int[] height) {
        int n = height.length;
        int[] dp = new int[n];

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int fs = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
            int ss = Integer.MAX_VALUE;

            if (i > 1) {
                ss = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
            }

            dp[i] = Math.min(fs, ss);
        }

        return dp[n - 1];
    }

    // --------------------------------
    //  Space Optimized DP
    // Time: O(n), Space: O(1)
    // --------------------------------
    public int minCostSpaceOptimized(int[] height) {
        int prev = 0;
        int prev2 = 0;
        int n = height.length;

        for (int i = 1; i < n; i++) {
            int fs = prev + Math.abs(height[i] - height[i - 1]);
            int ss = Integer.MAX_VALUE;

            if (i > 1) {
                ss = prev2 + Math.abs(height[i] - height[i - 2]);
            }

            int curr = Math.min(fs, ss);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        FrogJump obj = new FrogJump();

        System.out.println("Tabulation Answer: " + obj.minCostTabulation(height));
        System.out.println("Space Optimized Answer: " + obj.minCostSpaceOptimized(height));

        sc.close();
    }
}
