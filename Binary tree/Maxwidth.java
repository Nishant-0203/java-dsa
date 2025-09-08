import java.util.*;

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

// Helper Pair class
class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

// Solution class
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int minindex = q.peek().num; // To prevent overflow
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                int curr_id = curr.num - minindex;
                TreeNode node = curr.node;

                if (i == 0)
                    first = curr_id;
                if (i == size - 1)
                    last = curr_id;

                if (node.left != null)
                    q.offer(new Pair(node.left, curr_id * 2 + 1));
                if (node.right != null)
                    q.offer(new Pair(node.right, curr_id * 2 + 2));
            }

            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}

// Main class to test
public class Maxwidth {
    public static void main(String[] args) {
        // Build sample tree: [1,3,2,5,3,null,9]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        Solution sol = new Solution();
        int result = sol.widthOfBinaryTree(root);

        System.out.println("Maximum width of the binary tree: " + result);
    }
}
