// File: LowestCommonAncestor.java
import java.util.*;

public class LowestCommonAncestor {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        int curr = root.val;

        if (curr < p.val && curr < q.val)
            return lowestCommonAncestor(root.right, p, q);

        if (curr > p.val && curr > q.val)
            return lowestCommonAncestor(root.left, p, q);

        return root;
    }

    // Main method for VS Code testing
    public static void main(String[] args) {
        /*
         Example tree:
                 6
                / \
               2   8
              / \ / \
             0  4 7  9
               / \
              3   5
         */
        LowestCommonAncestor obj = new LowestCommonAncestor();

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left;        // Node with value 2
        TreeNode q = root.left.right;  // Node with value 4

        TreeNode lca = obj.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor: " + lca.val);
    }
}
