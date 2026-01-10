// https://leetcode.com/problems/insert-interval/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {

            // Case 1: interval completely before newInterval
            if (interval[1] < newInterval[0]) {
                result.add(interval);
            }
            // Case 2: interval completely after newInterval
            else if (interval[0] > newInterval[1]) {
                result.add(newInterval);
                newInterval = interval;
            }
            // Case 3: overlapping intervals
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        // Add the last merged interval
        result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        int[] newInterval = new int[2];
        newInterval[0] = sc.nextInt();
        newInterval[1] = sc.nextInt();

        int[][] result = insert(intervals, newInterval);

        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }

        sc.close();
    }
}
