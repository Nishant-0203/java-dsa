
import java.util.*;

public class KthLargestSubarraySum {

    public static int kthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (pq.size() < k) {
                    pq.add(sum);
                } else if (sum > pq.peek()) {
                    pq.poll();
                    pq.add(sum);
                }
            }
        }
        return pq.peek(); 
    }

    // Main method for VS Code testing
    public static void main(String[] args) {
        int[] arr1 = {20, -5, -1};
        int k1 = 3;
        System.out.println("The " + k1 + "rd largest subarray sum is: " + kthLargest(arr1, k1));

        int[] arr2 = {10, -10, 20, -40};
        int k2 = 6;
        System.out.println("The " + k2 + "th largest subarray sum is: " + kthLargest(arr2, k2));
    }
}
