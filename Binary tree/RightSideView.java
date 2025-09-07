// File: RightSideView.java

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

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size(); // number of nodes in current level
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // take the last node of each level
                if (i == size - 1) res.add(node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return res;
    }

    // Main method for testing
    public static void main(String[] args) {
        /*
              1
             / \
            2   3
             \    \
              5    4
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        RightSideView solution = new RightSideView();
        List<Integer> result = solution.rightSideView(root);

        System.out.println("Right Side View: " + result); 
        // Expected output: [1, 3, 4]
    }
}
