// LeetCode 889: Construct Binary Tree from Preorder and Postorder Traversal
// Works in VS Code

// Definition for a binary tree node.
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

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    int preIndex = 0;
    int postIndex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[preIndex++]);

        if (root.val != postorder[postIndex]) {
            root.left = constructFromPrePost(preorder, postorder);
        }
        if (root.val != postorder[postIndex]) {
            root.right = constructFromPrePost(preorder, postorder);
        }

        postIndex++;
        return root;
    }

    // Main method for testing in VS Code
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndPostorderTraversal obj =
                new ConstructBinaryTreeFromPreorderAndPostorderTraversal();

        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        TreeNode root = obj.constructFromPrePost(preorder, postorder);
        System.out.println("Tree constructed successfully. Root value: " + root.val);
    }
}
