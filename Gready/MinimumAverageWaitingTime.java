// https://www.geeksforgeeks.org/problems/minimum-average-waiting-time/1

import java.util.Arrays;
import java.util.Scanner;

public class MinimumAverageWaitingTime {

    public static int solve(int[] bt) {

        Arrays.sort(bt); // shortest job first

        int n = bt.length;
        int time = 0;
        int waiting = 0;

        for (int i = 0; i < n; i++) {
            waiting += time;
            time += bt[i];
        }

        return waiting / n; // integer division as per GFG
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] bt = new int[n];

        for (int i = 0; i < n; i++) {
            bt[i] = sc.nextInt();
        }

        System.out.println(solve(bt));

        sc.close();
    }
}
