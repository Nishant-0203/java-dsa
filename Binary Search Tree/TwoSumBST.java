// File: TwoSumBST.java
import java.util.*;

public class TwoSumBST {

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

    private ArrayList<Integer> list = new ArrayList<>();

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == k) {
                return true;
            }
            if (sum < k) left++;
            else right--;
        }

        return false;
    }

    // Main method for VS Code testing
    public static void main(String[] args) {
        /*
         Example tree:
                 5
                / \
               3   6
              / \   \
             2   4   7
         */
        TwoSumBST obj = new TwoSumBST();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3, new TreeNode(2), new TreeNode(4));
        root.right = new TreeNode(6, null, new TreeNode(7));

        int k = 9;
        boolean result = obj.findTarget(root, k);
        System.out.println("Find target " + k + " in BST: " + result);

        k = 28;
        result = obj.findTarget(root, k);
        System.out.println("Find target " + k + " in BST: " + result);
    }
}
