import java.util.Scanner;

public class TotalWaysToDistance {

    static int totalWaysToDistance(int d, int k) {
        int[] dp = new int[d + 1];
        dp[0] = 1; // One way to stay at start

        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[d];
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int d = sc.nextInt(); // distance
        int k = sc.nextInt(); // max steps in one go

        System.out.println(totalWaysToDistance(d, k));

        sc.close();
    }
}
