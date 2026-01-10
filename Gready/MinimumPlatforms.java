// https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1

import java.util.Arrays;
import java.util.Scanner;

public class MinimumPlatforms {

    public static int minPlatform(int[] arr, int[] dep) {

        Arrays.sort(arr);
        Arrays.sort(dep);

        int n = arr.length;
        int i = 0; // arrival pointer
        int j = 0; // departure pointer

        int platforms = 0;
        int maxPlatforms = 0;

        while (i < n && j < n) {

            // New train arrives before previous departs
            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
                maxPlatforms = Math.max(maxPlatforms, platforms);
            }
            // Train departs
            else {
                platforms--;
                j++;
            }
        }

        return maxPlatforms;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dep = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            dep[i] = sc.nextInt();
        }

        System.out.println(minPlatform(arr, dep));

        sc.close();
    }
}
