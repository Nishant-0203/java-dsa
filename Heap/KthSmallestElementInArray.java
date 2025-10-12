import java.util.*;
public class KthSmallestElementInArray {
    public int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : nums) {
            pq.add(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
    // Main method for VS Code testing
    public static void main(String[] args) {
        KthSmallestElementInArray obj = new KthSmallestElementInArray();

        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("The " + k1 + "th smallest element is: " + obj.findKthSmallest(nums1, k1));

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("The " + k2 + "th smallest element is: " + obj.findKthSmallest(nums2, k2));
    }
}
