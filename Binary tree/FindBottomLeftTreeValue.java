// File: FindBottomLeftTreeValue.java

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */
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

public class FindBottomLeftTreeValue {

    // BFS Approach
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode node = null;

        while (!q.isEmpty()) {
            node = q.poll();
            if (node.right != null) {
                q.offer(node.right);
            }
            if (node.left != null) {
                q.offer(node.left);
            }
        }
        return node.val;
    }

    /* 
     * Alternative Approach (Level Order Traversal)
     * Uncomment if you want to use this instead of BFS above.
     *
     * public int findBottomLeftValue(TreeNode root) {
     *     List<List<Integer>> list = new LinkedList<>();
     *     if (root == null) return -1;
     *
     *     Queue<TreeNode> queue = new LinkedList<>();
     *     queue.offer(root);
     *
     *     while(!queue.isEmpty()){
     *         LinkedList<Integer> level = new LinkedList<>();
     *         int size = queue.size();
     *
     *         for(int i = 0; i < size; i++){
     *             TreeNode current = queue.poll();
     *             level.add(current.val);
     *
     *             if (current.left != null) queue.offer(current.left);
     *             if (current.right != null) queue.offer(current.right);
     *         }
     *         list.add(level);
     *     }
     *
     *     List<Integer> lastLevel = list.get(list.size() - 1);
     *     return lastLevel.get(0);
     * }
     */

    // Main method for testing
    public static void main(String[] args) {
        /*
              2
             / \
            1   3
           /
          4
         */
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        FindBottomLeftTreeValue solution = new FindBottomLeftTreeValue();
        int result = solution.findBottomLeftValue(root);
        System.out.println("Bottom Left Value: " + result); // Expected output: 4
    }
}
