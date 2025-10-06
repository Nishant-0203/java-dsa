// File: KthSmallestElementInBST.java
import java.util.*;

public class KthSmallestElementInBST {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int count = 0;
    static int result = 0;

    // Function name same as LeetCode problem
    public static int kthSmallestElementInBST(TreeNode root, int k) {
        count = 0;  // reset count for each call
        result = 0; // reset result for each call
        inorder(root, k);
        return result;
    }

    private static void inorder(TreeNode node, int k) {
        if (node == null) return;

        // Left subtree
        inorder(node.left, k);

        // Visit current node
        count++;
        if (count == k) {
            result = node.val;
            return; // stop traversal once found
        }

        // Right subtree
        inorder(node.right, k);
    }

    // Utility function to build a sample BST
    public static TreeNode sampleTree() {
        // Example BST:
        //       5
        //      / \
        //     3   7
        //    / \   \
        //   2   4   8
        TreeNode n2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n2, n4);
        TreeNode n8 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7, null, n8);
        TreeNode n5 = new TreeNode(5, n3, n7);
        return n5;
    }

    public static void main(String[] args) {
        TreeNode root = sampleTree();
        int k = 3;

        int kthSmallest = kthSmallestElementInBST(root, k);
        System.out.println("The " + k + "-th smallest element is: " + kthSmallest);
    }
}
