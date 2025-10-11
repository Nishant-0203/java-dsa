// File: MergeKSortedLists.java
// Problem: Merge k Sorted Linked Lists
// Approach 1: Using Min Heap (PriorityQueue)
// Time Complexity: O(n * log(k))
// Space Complexity: O(k)
//
// Approach 2: Using Iterative Merge Sort
// Time Complexity: O(n * log(k))
// Space Complexity: O(1)

import java.util.*;

public class MergeKSortedLists {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // ----- Solution 1: Using Min Heap -----
    static class Solution1 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
            for (ListNode node : lists) {
                if (node != null) {
                    queue.offer(node);
                }
            }

            ListNode dummy = new ListNode(0);
            ListNode current = dummy;

            while (!queue.isEmpty()) {
                ListNode node = queue.poll();
                current.next = node;
                current = current.next;

                if (node.next != null) {
                    queue.offer(node.next);
                }
            }

            return dummy.next;
        }
    }

    // ----- Solution 2: Using Iterative Merge Sort -----
    static class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            int size = lists.length;
            int interval = 1;

            while (interval < size) {
                for (int i = 0; i < size - interval; i += 2 * interval) {
                    lists[i] = merge(lists[i], lists[i + interval]);
                }
                interval *= 2;
            }

            return size > 0 ? lists[0] : null;
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;

            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    curr.next = l1;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    l2 = l2.next;
                }
                curr = curr.next;
            }

            if (l1 != null) curr.next = l1;
            else curr.next = l2;

            return dummy.next;
        }
    }

    // ----- Helper Function to Create and Print Lists -----
    private static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // ----- Main Method for VS Code Testing -----
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = createList(new int[]{1, 4, 5});
        lists[1] = createList(new int[]{1, 3, 4});
        lists[2] = createList(new int[]{2, 6});

        // Using Min Heap Solution
        Solution1 heapSolution = new Solution1();
        ListNode result1 = heapSolution.mergeKLists(lists);
        System.out.print("Merged List using Min Heap: ");
        printList(result1);

        // Re-create lists for the second solution
        lists[0] = createList(new int[]{1, 4, 5});
        lists[1] = createList(new int[]{1, 3, 4});
        lists[2] = createList(new int[]{2, 6});

        // Using Merge Sort Solution
        Solution2 mergeSortSolution = new Solution2();
        ListNode result2 = mergeSortSolution.mergeKLists(lists);
        System.out.print("Merged List using Merge Sort: ");
        printList(result2);
    }
}
