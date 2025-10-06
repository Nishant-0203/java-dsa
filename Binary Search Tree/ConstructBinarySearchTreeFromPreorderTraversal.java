// File: ConstructBinarySearchTreeFromPreorderTraversal.java
import java.util.*;

public class ConstructBinarySearchTreeFromPreorderTraversal {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static int idx = 0;

    // Function name same as problem title (camel case)
    public static TreeNode constructBinarySearchTreeFromPreorderTraversal(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    private static TreeNode build(int[] preorder, int bound) {
        if (idx == preorder.length || preorder[idx] > bound)
            return null;

        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = build(preorder, root.val);
        root.right = build(preorder, bound);
        return root;
    }

    // Utility function to print inorder traversal
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = constructBinarySearchTreeFromPreorderTraversal(preorder);

        System.out.println("Inorder traversal of constructed BST:");
        printInorder(root);
    }
}
