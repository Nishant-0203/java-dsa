import java.util.HashMap;

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

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int idx = 0;

    public TreeNode result(int[] pre, int[] in, int start, int end, HashMap<Integer, Integer> mp, int n) {
        if (start > end || idx >= n) {
            return null;
        }
        int pos = mp.get(pre[idx]);
        TreeNode root = new TreeNode(pre[idx++]);

        root.left = result(pre, in, start, pos - 1, mp, n);
        root.right = result(pre, in, pos + 1, end, mp, n);

        return root;
    }

    public TreeNode buildTree(int[] pre, int[] in) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            mp.put(in[i], i);
        }
        return result(pre, in, 0, pre.length - 1, mp, pre.length);
    }

    // Main method for testing in VS Code
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal obj =
                new ConstructBinaryTreeFromPreorderAndInorderTraversal();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = obj.buildTree(preorder, inorder);
        System.out.println("Tree constructed successfully. Root value: " + root.val);
    }
}
