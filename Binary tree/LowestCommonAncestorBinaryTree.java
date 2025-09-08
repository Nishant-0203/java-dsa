// File: LowestCommonAncestorBinaryTree.java

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LowestCommonAncestorBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }

    // Main method for quick testing
    public static void main(String[] args) {
        /*
                3
               / \
              5   1
             / \ / \
            6  2 0  8
              / \
             7   4
        Example: LCA of 5 and 1 is 3
                  LCA of 5 and 4 is 5
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        LowestCommonAncestorBinaryTree solution = new LowestCommonAncestorBinaryTree();
        TreeNode lca1 = solution.lowestCommonAncestor(root, root.left, root.right); // LCA of 5 and 1
        TreeNode lca2 = solution.lowestCommonAncestor(root, root.left, root.left.right.right); // LCA of 5 and 4

        System.out.println("LCA of 5 and 1: " + lca1.val); // Expected: 3
        System.out.println("LCA of 5 and 4: " + lca2.val); // Expected: 5
    }
}
