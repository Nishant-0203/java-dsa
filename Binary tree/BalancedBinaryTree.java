// Filename: BalancedBinaryTree.java

// Definition for a binary tree node.
class TreeNode {
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

public class BalancedBinaryTree {
    // Helper method to check height and balance
    public int checkHeight(TreeNode root) {
        if (root == null) return 0;

        int left = checkHeight(root.left);
        if (left == -1) return -1;  // left subtree is unbalanced

        int right = checkHeight(root.right);
        if (right == -1) return -1; // right subtree is unbalanced

        if (Math.abs(left - right) > 1) return -1; // current node unbalanced

        return Math.max(left, right) + 1; // return height if balanced
    }

    // Main function to check if tree is balanced
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // Example test case (main method to run in VS Code)
    public static void main(String[] args) {
        // Creating a test tree: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        BalancedBinaryTree solution = new BalancedBinaryTree();
        System.out.println("Is tree balanced? " + solution.isBalanced(root)); // Expected: true
    }
}
