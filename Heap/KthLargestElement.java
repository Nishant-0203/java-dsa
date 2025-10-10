// File: KthLargestElement.java
import java.util.*;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        // Create a min heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // Iterate over the array
        for (int n : nums) {
            heap.add(n);
            // Keep only k largest elements in the heap
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Root of the heap is the kth largest element
        return heap.peek();
    }

    // Main method for VS Code testing
    public static void main(String[] args) {
        KthLargestElement obj = new KthLargestElement();

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = obj.findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        k = 4;
        result = obj.findKthLargest(nums2, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }
}
