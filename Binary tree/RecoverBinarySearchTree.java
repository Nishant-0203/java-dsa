// https://leetcode.com/problems/recover-binary-search-tree/

import java.util.Scanner;

public class RecoverBinarySearchTree {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static TreeNode first = null;
    private static TreeNode second = null;
    private static TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    // Inorder traversal to detect swapped nodes
    public static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (first == null && prev.val > root.val) {
            first = prev;
        }
        if (first != null && prev.val > root.val) {
            second = root;
        }

        prev = root;
        inorder(root.right);
    }

    public static void recoverTree(TreeNode root) {
        inorder(root);

        // Swap values of the two misplaced nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        /*
            Example:
                Original BST (with two nodes swapped):
                        3
                       / \
                      1   4
                         /
                        2

            After recovery:
                        2
                       / \
                      1   4
                         /
                        3
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        recoverTree(root);

        // Simple inorder print to verify
        printInorder(root);
    }

    // Utility to verify result
    private static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}
