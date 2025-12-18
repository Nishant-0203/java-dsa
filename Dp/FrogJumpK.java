import java.util.Scanner;

public class FrogJumpK {

    // DP with K jumps (Tabulation)
    public int frogJump(int[] height, int k) {
        int n = height.length;
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }

            dp[i] = minSteps;
        }

        return dp[n - 1];
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        FrogJumpK obj = new FrogJumpK();
        System.out.println(obj.frogJump(height, k));

        sc.close();
    }
}
