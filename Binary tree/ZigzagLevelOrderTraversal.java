// Filename: ZigzagLevelOrderTraversal.java

import java.util.*;

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

public class ZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean change = true;

        while (!queue.isEmpty()) {
            int levelsize = queue.size();
            ArrayList<Integer> list1 = new ArrayList<>();

            for (int i = 0; i < levelsize; i++) {
                TreeNode current = queue.poll();
                list1.add(current.val);

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            if (!change) {
                Collections.reverse(list1);
            }
            list.add(list1);
            change = !change;
        }
        return list;
    }

    // Example test case
    public static void main(String[] args) {
        /*
              1
             / \
            2   3
           / \   \
          4   5   6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3, null, new TreeNode(6));

        ZigzagLevelOrderTraversal solution = new ZigzagLevelOrderTraversal();
        List<List<Integer>> result = solution.zigzagLevelOrder(root);

        System.out.println("Zigzag Level Order Traversal: " + result);
        // Expected Output: [[1], [3, 2], [4, 5, 6]]
    }
}
