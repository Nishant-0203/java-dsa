// https://www.geeksforgeeks.org/problems/geeks-training/1
import java.util.Arrays;
import java.util.Scanner;

public class NinjaTraining {

    // Memoization helper
    public int helper(int[][] arr, int day, int last, int[][] dp) {

        if (dp[day][last] != -1)
            return dp[day][last];

        // Base case: day 0
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, arr[0][task]);
                }
            }
            return dp[day][last] = maxi;
        }

        int maxi = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int points = arr[day][task] + helper(arr, day - 1, task, dp);
                maxi = Math.max(maxi, points);
            }
        }

        return dp[day][last] = maxi;
    }

    // Main function
    public int maximumPoints(int[][] arr) {
        int n = arr.length;
        int[][] dp = new int[n][4];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(arr, n - 1, 3, dp);
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of days
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        NinjaTraining obj = new NinjaTraining();
        System.out.println(obj.maximumPoints(arr));

        sc.close();
    }
}
