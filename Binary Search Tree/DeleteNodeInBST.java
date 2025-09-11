// Definition for a binary tree node
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

class Solution {
    public TreeNode findlastright(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return findlastright(root.right);
    }

    public TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode rightchild = root.right;
        TreeNode lastright = findlastright(root.left);
        lastright.right = rightchild;
        return root.left;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return helper(root);
        }
        TreeNode dummy = root;
        while (root != null) {
            if (root.val >= key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }
}

public class DeleteNodeInBST {
    // Helper method to print tree inorder
    public static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        // Example Tree
        /*
                 5
                / \
               3   6
              / \    \
             2   4    7
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        Solution sol = new Solution();

        System.out.println("Original Tree (Inorder): ");
        inorder(root);
        System.out.println();

        // Delete a node
        root = sol.deleteNode(root, 3);

        System.out.println("After Deletion of 3 (Inorder): ");
        inorder(root);
    }
}
