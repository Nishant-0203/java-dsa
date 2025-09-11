// File: SearchBST.java

/**
 * Definition for a binary tree node.
 */
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

public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }

    // 🔹 main method for testing
    public static void main(String[] args) {
        // Build a sample BST
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(13);

        SearchBST solution = new SearchBST();

        int val = 6;
        TreeNode result = solution.searchBST(root, val);
        System.out.println(result != null ? "Found: " + result.val : "Not Found");

        val = 13;
        result = solution.searchBST(root, val);
        System.out.println(result != null ? "Found: " + result.val : "Not Found");

        val = 2;
        result = solution.searchBST(root, val);
        System.out.println(result != null ? "Found: " + result.val : "Not Found");
    }
}
