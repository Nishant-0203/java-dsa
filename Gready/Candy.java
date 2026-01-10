// https://leetcode.com/problems/candy/

import java.util.Scanner;

public class Candy {

    public static int candy(int[] ratings) {

        int n = ratings.length;

        int[] left = new int[n];
        int[] right = new int[n];

        // Left to right pass
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        // Right to left pass
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        // Take max from both passes
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(left[i], right[i]);
        }

        return sum;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ratings = new int[n];

        for (int i = 0; i < n; i++) {
            ratings[i] = sc.nextInt();
        }

        System.out.println(candy(ratings));

        sc.close();
    }
}
