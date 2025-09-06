import java.util.*;

// Definition for a binary tree node
class TreeNode {
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

public class MinimumDepthOfBinaryTree {
    // Main solution method (LeetCode style)
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        // If left is null, recurse only on right
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        // If right is null, recurse only on left
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        // If both children exist, take the minimum depth
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    // Driver code for testing in VS Code
    public static void main(String[] args) {
        // Constructing a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        MinimumDepthOfBinaryTree sol = new MinimumDepthOfBinaryTree();
        int depth = sol.minDepth(root);

        System.out.println("Minimum Depth of Binary Tree: " + depth);
        // Expected: 2 (shortest path is root -> right child)
    }
}
