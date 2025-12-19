// https://leetcode.com/problems/fibonacci-number/
import java.util.Arrays;
import java.util.Scanner;

public class FibonacciNumber {

    // Memoization (Top-Down DP)
    public int fibMemo(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return dp[n] = n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = fibMemo(n - 1, dp) + fibMemo(n - 2, dp);
    }

    // Tabulation (Bottom-Up DP)
    public int fibTab(int n) {
        if (n == 0) return 0;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Main method to run from VS Code
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        FibonacciNumber obj = new FibonacciNumber();
        int ans = obj.fibMemo(n, dp);

        System.out.println(ans);

        sc.close();
    }
}
