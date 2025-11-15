// File: MergeKSortedLists.java
// Problem: Merge k sorted linked lists and return it as one sorted list
// Approaches:
// 1) Using Min Heap (Efficient) - O(N log k)
// 2) Using ArrayList + Sort (Simpler) - O(N log N)

import java.util.*;

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLists {

    // Approach 1: Using Min Heap
    public ListNode mergeKLists_MinHeap(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            prev.next = node;
            prev = prev.next;

            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }

    // Approach 2: Using ArrayList and Sorting
    public ListNode mergeKLists_Sorting(ListNode[] lists) {
        List<Integer> values = new ArrayList<>(); 

        for (ListNode head : lists) {
            while (head != null) {
                values.add(head.val);
                head = head.next;
            }
        }

        Collections.sort(values);

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }

    // Utility: Print Linked List
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method for VS Code testing
    public static void main(String[] args) {
        MergeKSortedLists obj = new MergeKSortedLists();

        // Example: 3 sorted lists
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = {l1, l2, l3};

        System.out.println("Using Min Heap:");
        ListNode mergedHeap = obj.mergeKLists_MinHeap(lists);
        printList(mergedHeap);

        // Recreate lists (since they get consumed)
        l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        l3 = new ListNode(2, new ListNode(6));
        lists = new ListNode[]{l1, l2, l3};

        System.out.println("Using Sorting:");
        ListNode mergedSort = obj.mergeKLists_Sorting(lists);
        printList(mergedSort);
    }
}
