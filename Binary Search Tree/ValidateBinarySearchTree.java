// File: ValidateBinarySearchTree.java
import java.util.*;

public class ValidateBinarySearchTree {

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

    // Function name same as problem title
    public static boolean validateBinarySearchTree(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean helper(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;

        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }

    // Utility function to build a tree for testing
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

        boolean isBST = validateBinarySearchTree(root);
        System.out.println("Is the tree a valid BST? " + isBST);
    }
}
