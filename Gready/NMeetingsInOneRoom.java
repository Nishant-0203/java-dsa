// https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

import java.util.Arrays;
import java.util.Scanner;

public class NMeetingsInOneRoom {

    public static int maxMeetings(int[] start, int[] end) {

        int n = start.length;
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }

        // Sort meetings by end time
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);

        int count = 1;
        int lastEnd = meetings[0][1];

        for (int i = 1; i < n; i++) {
            if (meetings[i][0] > lastEnd) {
                count++;
                lastEnd = meetings[i][1];
            }
        }

        return count;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            end[i] = sc.nextInt();
        }

        System.out.println(maxMeetings(start, end));

        sc.close();
    }
}
