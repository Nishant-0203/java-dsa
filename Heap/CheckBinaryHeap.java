// File: CheckBinaryHeap.java
// Problem: Check if a Binary Tree is a Heap
// Approach: Recursively check completeness and max-heap property
// Time Complexity: O(n)
// Space Complexity: O(h) (recursion stack, h = height of tree)

import java.util.*;

public class CheckBinaryHeap {

    // Definition for a binary tree node
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static class Solution {

        // Count total nodes in the tree
        static int countNodes(Node root) {
            if (root == null) return 0;
            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);
            return 1 + leftCount + rightCount;
        }

        // Check max-heap property
        boolean maxHeap(Node root) {
            if (root.left == null && root.right == null) return true;

            if (root.right == null) {
                return root.data >= root.left.data && maxHeap(root.left);
            }

            if (root.data >= root.left.data && root.data >= root.right.data) {
                return maxHeap(root.left) && maxHeap(root.right);
            }

            return false;
        }

        // Check completeness of the tree
        boolean complete(Node root, int i, int nodeCount) {
            if (root == null) return true;
            if (i >= nodeCount) return false;

            boolean left = complete(root.left, 2 * i + 1, nodeCount);
            boolean right = complete(root.right, 2 * i + 2, nodeCount);
            return left && right;
        }

        // Main function to check if tree is a heap
        boolean isHeap(Node tree) {
            int count = countNodes(tree);
            return complete(tree, 0, count) && maxHeap(tree);
        }
    }

    // Main method for VS Code testing
    public static void main(String[] args) {
        /*
         Example tree:
                 10
                /  \
               9    8
              / \  /
             7  6 5
        */
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);

        Solution sol = new Solution();
        boolean result = sol.isHeap(root);
        System.out.println("Is the tree a heap? " + result);
    }
}
