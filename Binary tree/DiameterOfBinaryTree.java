// Filename: DiameterOfBinaryTree.java

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

public class DiameterOfBinaryTree {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Update diameter at this node (number of edges in the longest path)
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Example test case (main method to run in VS Code)
    public static void main(String[] args) {
        // Create test tree: [1,2,3,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3);

        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();
        System.out.println("Diameter of tree: " + solution.diameterOfBinaryTree(root)); 
        // Expected output: 3
    }
}
