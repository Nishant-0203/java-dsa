// https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {

    public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {

        int n = val.length;

        // Each item: {value, weight, ratio}
        double[][] items = new double[n][3];

        for (int i = 0; i < n; i++) {
            items[i][0] = val[i];
            items[i][1] = wt[i];
            items[i][2] = (double) val[i] / wt[i]; // value per weight
        }

        // Sort by ratio descending
        Arrays.sort(items, (a, b) -> Double.compare(b[2], a[2]));

        double totalValue = 0.0;

        for (int i = 0; i < n && capacity > 0; i++) {

            double weight = items[i][1];
            double value = items[i][0];

            if (weight <= capacity) {
                // Take full item
                totalValue += value;
                capacity -= weight;
            } else {
                // Take fractional part
                totalValue += items[i][2] * capacity;
                capacity = 0;
            }
        }

        return totalValue;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] val = new int[n];
        int[] wt = new int[n];

        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }

        int capacity = sc.nextInt();

        System.out.println(fractionalKnapsack(val, wt, capacity));

        sc.close();
    }
}
