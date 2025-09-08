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

class Solution {
    class Pair {
        int ht;
        boolean found;
        public Pair(int ht, boolean found) {
            this.ht = ht;
            this.found = found;
        }
    }

    int depth = 0;
    int subDepth = 0;

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return Math.max(depth, subDepth);
    }

    private Pair dfs(TreeNode root, int start) {
        if (root == null) {
            return new Pair(0, false);
        }

        Pair left = dfs(root.left, start);
        Pair right = dfs(root.right, start);

        if (root.val == start) {
            subDepth = Math.max(left.ht, right.ht);
            return new Pair(1, true);
        }

        if (left.found) {
            depth = Math.max(depth, left.ht + right.ht);
            left.ht++;
            return left;
        }

        if (right.found) {
            depth = Math.max(depth, left.ht + right.ht);
            right.ht++;
            return right;
        }

        return new Pair(Math.max(left.ht, right.ht) + 1, false);
    }
}

public class amountOfTime {
    public static void main(String[] args) {
        // Example tree: [1,5,3,null,4,10,6,9,2]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);

        int start = 3;

        Solution sol = new Solution();
        int result = sol.amountOfTime(root, start);

        System.out.println("Minutes to infect whole tree: " + result);
    }
}
