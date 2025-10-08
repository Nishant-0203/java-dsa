// File: RecoverBinarySearchTree.java
import java.util.*;

public class RecoverBinarySearchTree {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    private void inorder(TreeNode root) {
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

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    // Helper function to print in-order traversal
    public void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // Main method for VS Code testing
    public static void main(String[] args) {
        /*
         Example tree:
             3
            / \
           1   4
              /
             2

         After swapping 2 and 3, we get:
             2
            / \
           1   4
              /
             3
        */
        RecoverBinarySearchTree obj = new RecoverBinarySearchTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        System.out.println("Before recovery (inorder):");
        obj.printInorder(root);

        obj.recoverTree(root);

        System.out.println("\nAfter recovery (inorder):");
        obj.printInorder(root);
    }
}
