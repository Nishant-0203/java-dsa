import java.util.*;

public class KSortedArrayCheck {

    static class Pair {
        int val, idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    static String isKSortedArray(int arr[], int n, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int j = 0;

        // Add elements with their original indices
        for (int i = 0; i < n; i++) {
            pq.add(new Pair(arr[i], i));
            if (pq.size() > k + 1) {
                Pair p = pq.poll();
                if (Math.abs(p.idx - j) > k) {
                    return "No";
                }
                j++;
            }
        }

        // Check remaining elements
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (Math.abs(p.idx - j) > k) {
                return "No";
            }
            j++;
        }

        return "Yes";
    }

    // Main method for VS Code testing
    public static void main(String[] args) {
        int[] arr1 = {3, 2, 1};
        int k1 = 1;
        System.out.println("Is array K-sorted? " + isKSortedArray(arr1, arr1.length, k1)); // Output: No

        int[] arr2 = {2, 1, 3, 5, 4};
        int k2 = 2;
        System.out.println("Is array K-sorted? " + isKSortedArray(arr2, arr2.length, k2)); // Output: Yes
    }
}
