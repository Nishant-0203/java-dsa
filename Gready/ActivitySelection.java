// https://www.geeksforgeeks.org/problems/activity-selection-1587115620/1

import java.util.*;

public class ActivitySelection {

    // Print the starting time of selected activities in sorted order
    public static void activitySelection(int[] start, int[] finish) {
 
        int n = start.length;
        int[][] act = new int[n][2];

        for (int i = 0; i < n; i++) {
            act[i][0] = start[i];
            act[i][1] = finish[i];
        }

        // Sort activities by finish time
        Arrays.sort(act, (a, b) -> a[1] - b[1]);

        ArrayList<Integer> res = new ArrayList<>();

        // Select first activity
        res.add(act[0][0]);
        int lastEnd = act[0][1];

        for (int i = 1; i < n; i++) {
            if (act[i][0] >= lastEnd) {
                res.add(act[i][0]);
                lastEnd = act[i][1];
            }
        }

        // GFG expects output in sorted order of start times
        Collections.sort(res);

        for (int x : res) {
            System.out.print(x + " ");
        }
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] start = new int[n];
        int[] finish = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            finish[i] = sc.nextInt();
        }

        activitySelection(start, finish);

        sc.close();
    }
}
