// File: RankTransformOfArray.java
// Problem: Rank Transform of an Array
// Approach: Use Min Heap (PriorityQueue) to sort values with indices
// Time Complexity: O(n log n)
// Space Complexity: O(n)

import java.util.*;

public class RankTransformOfArray {

    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if (n == 0) return new int[0];

        // Min heap storing {value, original index}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{arr[i], i});
        }

        int[] result = new int[n];
        int rank = 1;
        int prevVal = pq.peek()[0];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int val = curr[0];
            int idx = curr[1];

            if (val != prevVal) {
                rank++;
                prevVal = val;
            }

            result[idx] = rank;
        }

        return result;
    }

    // Main method for VS Code testing
    public static void main(String[] args) {
        RankTransformOfArray obj = new RankTransformOfArray();

        int[] arr1 = {40, 10, 20, 30};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Rank Transform: " + Arrays.toString(obj.arrayRankTransform(arr1)));

        int[] arr2 = {100, 100, 100};
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Rank Transform: " + Arrays.toString(obj.arrayRankTransform(arr2)));

        int[] arr3 = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        System.out.println("Input: " + Arrays.toString(arr3));
        System.out.println("Rank Transform: " + Arrays.toString(obj.arrayRankTransform(arr3)));
    }
}
